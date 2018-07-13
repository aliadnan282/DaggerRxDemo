package com.mvvm.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mvvm.data.entity.DailyExerciseProgress;

import java.util.List;

/**
 * Created by AdnanAli on 3/12/2018.
 */

@Dao
public interface DailyExerciseProgressDao {
    @Query("SELECT * FROM daily_exercise_progress WHERE plan_id=:plan")
    LiveData<List<DailyExerciseProgress>> getAllDayProgress(int plan);

    @Query("SELECT * FROM daily_exercise_progress WHERE plan_id=:plan ")
    List<DailyExerciseProgress> getAllDayProgressSyn(int plan);

    @Query("SELECT * FROM daily_exercise_progress WHERE plan_id=:plan AND today_status=:flag")
    LiveData<List<DailyExerciseProgress>> getNextDay(int plan, boolean flag);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDayExerciseProgess(List<DailyExerciseProgress> dailyExerciseProgresses);

    @Update
    void updateDay(DailyExerciseProgress... dailyExerciseProgresses);

    @Update
    void updateAllDays(List<DailyExerciseProgress> dailyExerciseProgresses);

}
