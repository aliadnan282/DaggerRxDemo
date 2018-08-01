package com.mvvm.di;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.mvvm.App;
import com.mvvm.common.domain.model.CommonGreetingRepository;
import com.mvvm.data.database.AppDatabase;
import com.mvvm.data.repository.RoomRepository;
import com.mvvm.helper.AppPreference;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.mvvm.data.database.AppDatabase.DATABASE_NAME;

/**
 * This is where you will inject application-wide dependencies.
 */
@Module
public class AppModule {

    Context context;

    @Singleton
    @Provides
    Context provideContext(App application) {
        context= application.getApplicationContext();
        return context;
    }

    @Singleton
    @Provides
    CommonGreetingRepository provideCommonHelloService() {
        return new CommonGreetingRepository();
    }

    @Singleton
    @Provides
    AppPreference provideSharedPreferences(Context context) {
        return AppPreference.getInstance(context);
    }

    @Singleton
    @Provides
    AppDatabase provideDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                // .addCallback(sRoomDatabaseCallback)
                .build();
    }

    @Singleton
    @Provides
    RoomRepository provideRepository(AppDatabase appDatabase) {
        return new RoomRepository(appDatabase);
    }
}
