package com.mvvm.module;

import com.mvvm.common.domain.interactors.LoadCommonGreetingUseCase;
import com.mvvm.data.repository.RoomRepository;
import com.mvvm.rx.SchedulersFacade;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Define LobbyActivity-specific dependencies here.
 */
@Module
public class DaysModule {

    @Singleton
    @Provides
    RoomRepository providRoomRepository() {
        return new RoomRepository();
    }

    @Provides
    DaysModelFactory provideDaysModelFactory(LoadCommonGreetingUseCase loadCommonGreetingUseCase, SchedulersFacade schedulersFacade) {
        return new DaysModelFactory(loadCommonGreetingUseCase, schedulersFacade);
    }
}
