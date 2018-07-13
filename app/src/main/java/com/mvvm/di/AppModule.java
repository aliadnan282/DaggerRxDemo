package com.mvvm.di;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.mvvm.App;
import com.mvvm.common.domain.model.CommonGreetingRepository;
import com.mvvm.data.database.AppDatabase;
import com.mvvm.helper.AppConstant;
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

    @Provides
    Context provideContext(App application) {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    CommonGreetingRepository provideCommonHelloService() {
        return new CommonGreetingRepository();
    }

    @Singleton
    @Provides
    AppPreference provideSharedPreferences() {
        return AppPreference.getInstance(AppConstant.mContext);
    }

    @Singleton
    @Provides
    AppDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(application, AppDatabase.class, DATABASE_NAME)
                // .addCallback(sRoomDatabaseCallback)
                .build();
    }
}
