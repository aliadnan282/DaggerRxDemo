package com.mvvm.module;

import com.mvvm.data.database.AppDatabase;
import com.mvvm.data.repository.RoomRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Define LobbyActivity-specific dependencies here.
 */
@Module
public class DaysModule {

  /*  @Singleton
    @Provides
    RoomRepository providRoomRepository(AppDatabase appDatabase) {
        return new RoomRepository(appDatabase);
    }*/

    @Provides
    DaysModelFactory provideDaysModelFactory(RoomRepository roomRepository) {
        return new DaysModelFactory(roomRepository);
    }
}
