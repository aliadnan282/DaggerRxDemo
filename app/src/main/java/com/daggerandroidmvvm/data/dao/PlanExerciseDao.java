package com.daggerandroidmvvm.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SimpleSQLiteQuery;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RawQuery;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;


import com.daggerandroidmvvm.data.entity.PlanExercise;
import com.daggerandroidmvvm.data.entity.UniqueDayEntity;
import com.daggerandroidmvvm.data.pojo.CompleteExercise;
import com.daggerandroidmvvm.model.AchievementsDayProgress;

import java.util.List;

/**
 * Created by AdnanAli on 3/13/2018.
 */
@Dao
public interface PlanExerciseDao {


    @Query("SELECT * FROM `plan_exercise` WHERE plan_id=:type GROUP BY day_id")
    LiveData<List<PlanExercise>> getSelectedPlanDays(int type);

    @Query("SELECT * FROM `plan_exercise` WHERE plan_id=:type")
    List<PlanExercise> getPlanExercisesUnobservable(int type);

    @Query("SELECT * FROM `plan_exercise` WHERE plan_id=:type AND day_id=:day")
    LiveData<List<PlanExercise>> getSelectedDayExercise(int type, int day);

    @Query("SELECT * FROM `plan_exercise` WHERE plan_id=:type AND exe_status=1")
    PlanExercise findCompleteDays(int type);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPlanDays(PlanExercise... planDays);

    @Delete
    void deletePlanDay(PlanExercise planDays);


    @Transaction
    @Query("SELECT  *from plan_exercise WHERE plan_id=:plan  AND day_id=:day")
    List<CompleteExercise> getDayExerciseDetail(int plan, int day);

    @Transaction
    @Query("SELECT  *from plan_exercise WHERE plan_id=:plan  AND day_id=:day")
    LiveData<List<CompleteExercise>> getDayExerciseDetailObservable(int plan, int day);

    @Update
    void updateDay(PlanExercise... planExercises);

    @RawQuery(observedEntities = UniqueDayEntity.class)
    LiveData<List<AchievementsDayProgress>> getAchievementProgress(SimpleSQLiteQuery simpleSQLiteQuery);


/*
*
SELECT 1.0 * COUNT(*) / (select count(*) as t from plan_exercise where plan_id=1 and day_id=1) *100 AS percentage
FROM plan_exercise
 WHERE plan_id=1 and day_id= 1 and exe_status =1
GROUP BY exe_status


* */

}
