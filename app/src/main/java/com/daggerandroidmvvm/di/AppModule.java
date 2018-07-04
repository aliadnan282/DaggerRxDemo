package com.daggerandroidmvvm.di;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.daggerandroidmvvm.App;
import com.daggerandroidmvvm.common.domain.model.CommonGreetingRepository;
import com.daggerandroidmvvm.data.database.AppDatabase;
import com.daggerandroidmvvm.helper.AppConstant;
import com.daggerandroidmvvm.helper.AppPreference;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.daggerandroidmvvm.data.database.AppDatabase.DATABASE_NAME;

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
    AppDatabase provideDatabase() {
       return Room.databaseBuilder(get, AppDatabase.class, DATABASE_NAME)
               // .addCallback(sRoomDatabaseCallback)
                .build();
    }
}
