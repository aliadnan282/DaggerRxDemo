/*
package com.mvvm.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.mvvm.data.dao.DailyExerciseProgressDao;
import com.mvvm.data.database.AppDatabase;
import com.mvvm.data.repository.RoomRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    private AppDatabase demoDatabase;

    public RoomModule(Application mApplication) {
        demoDatabase = Room.databaseBuilder(mApplication, AppDatabase.class, "demo-db").build();
    }

    @Singleton
    @Provides
    AppDatabase providesRoomDatabase() {
        return demoDatabase;
    }

    @Singleton
    @Provides
    DailyExerciseProgressDao providesProductDao(AppDatabase appDatabase) {
        return appDatabase.dailyExerciseProgressDao();
    }

    @Singleton
    @Provides
    RoomRepository productRepository(DailyExerciseProgressDao productDao) {
        return new RoomRepository(productDao);
    }

}*/
