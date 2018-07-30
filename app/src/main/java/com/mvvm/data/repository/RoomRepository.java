package com.mvvm.data.repository;

import android.arch.lifecycle.LiveData;

import com.mvvm.data.database.AppDatabase;
import com.mvvm.data.entity.DailyExerciseProgress;

import java.util.List;

import javax.inject.Inject;

public class RoomRepository {


    AppDatabase database;

    @Inject
    public RoomRepository(AppDatabase appDatabase) {
        this.database = appDatabase;

    }

    public LiveData<List<DailyExerciseProgress>> getDays() {
        return database.dailyExerciseProgressDao().getAllDayProgress(1);
    }

    public void insertData(List<DailyExerciseProgress> list) {
        database.dailyExerciseProgressDao().insertDayExerciseProgess(list);
    }
}
