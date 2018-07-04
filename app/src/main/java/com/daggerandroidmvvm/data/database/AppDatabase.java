package com.daggerandroidmvvm.data.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;


import com.daggerandroidmvvm.data.dao.AchievementsDao;
import com.daggerandroidmvvm.data.dao.DailyExerciseProgressDao;
import com.daggerandroidmvvm.data.dao.ExerciseDetailDao;
import com.daggerandroidmvvm.data.dao.PlanExerciseDao;
import com.daggerandroidmvvm.data.dao.UniqueDayEntityDao;
import com.daggerandroidmvvm.data.entity.Achievement;
import com.daggerandroidmvvm.data.entity.DailyExerciseProgress;
import com.daggerandroidmvvm.data.entity.ExerciseDetail;
import com.daggerandroidmvvm.data.entity.PlanExercise;
import com.daggerandroidmvvm.data.entity.UniqueDayEntity;
import com.daggerandroidmvvm.helper.AppConstant;
import com.daggerandroidmvvm.helper.AppPreference;
import com.daggerandroidmvvm.helper.SixPackThreadPoolExecutor;
import com.daggerandroidmvvm.manager.JsonManager;
import com.daggerandroidmvvm.model.Day;
import com.daggerandroidmvvm.model.Exercise;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.daggerandroidmvvm.helper.AppConstant.IS_FIRST_RUN;
import static com.daggerandroidmvvm.helper.AppConstant.NOTIFICATION_ENABLE;
import static com.daggerandroidmvvm.helper.AppConstant.SNOOZE_NOTIFICATION;
import static com.daggerandroidmvvm.helper.AppConstant.TTS_UNMUTE;


/**
 * Created by AdnanAli on 3/12/2018.
 */

@Database( exportSchema = false, entities = {UniqueDayEntity.class, Achievement.class, PlanExercise.class, ExerciseDetail.class, DailyExerciseProgress.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "stretch";
    private static final String TAG = "AppDatabase";

     AppPreference appPreference;

    private static AppDatabase INSTANCE;
    /**
     * Override the onOpen method to populate the database.
     * For this sample, we clear the database every time it is created or opened.
     */
    public  Callback sRoomDatabaseCallback = new Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Log.d(TAG, "onCreate: database");
            Scheduler scheduler = Schedulers.from(SixPackThreadPoolExecutor.getInstance());
            if (!appPreference.getBoolean(IS_FIRST_RUN)) {
                Observable.fromCallable(() -> {
                    insertPlanDaysData();
                    insertExerciseDetail();
                    insert45Days();
                    insertAchievements();
                    return true;
                })
                        .subscribeOn(scheduler)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe((result) -> {

                            appPreference.setBoolean(IS_FIRST_RUN, true);
                            appPreference.setBoolean(SNOOZE_NOTIFICATION, true);
                            appPreference.setBoolean(TTS_UNMUTE, true);
                            appPreference.setBoolean(NOTIFICATION_ENABLE, true);
                        });
            }
        }
    };

    private AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            appPreference=AppPreference.getInstance(context);
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                    .addCallback(sRoomDatabaseCallback)
                    .build();
            Log.d(TAG, "getInstance: database");
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private void insertExerciseDetail() {
        List<ExerciseDetail> exerciseDetailList = JsonManager.getInstance().getExerciseDetailList();
        exerciseDetailDao().insertCategory(exerciseDetailList);
    }

    private  void insert45Days() {
        List<DailyExerciseProgress> list = new ArrayList<>();
        int daySize = 0;
        for (int i = 1; i < 4; i++) {
            if (i == 1)
                daySize = 22;
            else if (i == 2)
                daySize = 31;

            else daySize = 46;

            for (int j = 1; j < daySize; j++) {
                list.add(new DailyExerciseProgress(i, j, false));
            }
          dailyExerciseProgressDao().insertDayExerciseProgess(list);
        }
    }

    private  void insertPlanDaysData() {
        Log.d(TAG, "insertPlanDaysData: ");
        List<Day> dayList = JsonManager.getInstance().getPlanExercise();
        for (Day day : dayList) {
            for (Exercise exercise : day.getExerciseList()) {
                PlanExercise planExercise1 = new PlanExercise(day.getPlanId(), day.getDayId(), exercise.getExerciseId(), exercise.getExerciseName(), exercise.getExerciseReps(), exercise.getExerciseStatus());
              planExerciseDao().insertPlanDays(planExercise1);
            }

        }
    }

    private  void insertAchievements() {

        Log.d(TAG, "insertAchievements: ");
        for (int i = 1; i <= 15; i++) {
            Achievement achievement = new Achievement(i, i + (i - 1), false);
           achievementsDao().insertAchievements(achievement);
        }
    }

    public abstract PlanExerciseDao planExerciseDao();

    public abstract DailyExerciseProgressDao dailyExerciseProgressDao();

    public abstract ExerciseDetailDao exerciseDetailDao();

    public abstract AchievementsDao achievementsDao();

    public abstract UniqueDayEntityDao uniqueDayEntityDao();

}
