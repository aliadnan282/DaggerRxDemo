package com.daggerandroidmvvm.data.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

/**
 * Created by AdnanAli on 3/12/2018.
 */
@Entity(tableName = "daily_exercise_progress", primaryKeys = {"plan_id", "day_id"})
public class DailyExerciseProgress {

    @ColumnInfo(name = "plan_id")
    int planId;
    @ColumnInfo(name = "day_id")
    int dayId;
    @ColumnInfo(name = "day_percent")
    double dayPercent;
    @ColumnInfo(name = "today_status")

    boolean isDayComplete;

    public DailyExerciseProgress(int planId, int dayId, boolean isDayComplete) {
        this.planId = planId;
        this.dayId = dayId;
        this.isDayComplete = isDayComplete;
    }

    public double getDayPercent() {
        return dayPercent;
    }

    public void setDayPercent(double dayPercent) {
        this.dayPercent = dayPercent;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public boolean isDayComplete() {
        return isDayComplete;
    }

    public void setDayComplete(boolean dayComplete) {
        isDayComplete = dayComplete;
    }


}
