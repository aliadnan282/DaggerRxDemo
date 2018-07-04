package com.daggerandroidmvvm.data.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by AdnanAli on 3/12/2018.
 */
@Entity(tableName = "unique_day_entity")
public class UniqueDayEntity {
    @PrimaryKey
    @ColumnInfo(name = "day_id")
    long dayId;
    @ColumnInfo(name = "today_date")
    String todayDate;


    public UniqueDayEntity(long id, String date) {
        this.dayId = id;
        this.todayDate = date;
    }

    public UniqueDayEntity() {
    }

    public long getDayId() {
        return dayId;
    }

    public void setDayId(long dayId) {
        this.dayId = dayId;
    }

    public String getTodayDate() {
        return todayDate;
    }

    public void setTodayDate(String todayDate) {
        this.todayDate = todayDate;
    }

}
