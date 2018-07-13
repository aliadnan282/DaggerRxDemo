package com.mvvm.lobby;

import com.mvvm.common.domain.interactors.LoadCommonGreetingUseCase;
import com.mvvm.helper.AppConstant;
import com.mvvm.helper.AppPreference;
import com.mvvm.rx.SchedulersFacade;

import dagger.Module;
import dagger.Provides;


/**
 * Define LobbyActivity-specific dependencies here.
 */
@Module
public class LobbyModule {

    @Provides
    LobbyGreetingRepository provideLobbyGreetingRepository() {
        return new LobbyGreetingRepository();
    }

    @Provides
    LobbyViewModelFactory provideLobbyViewModelFactory(LoadCommonGreetingUseCase loadCommonGreetingUseCase,
                                                       LoadLobbyGreetingUseCase loadLobbyGreetingUseCase,
                                                       SchedulersFacade schedulersFacade) {
        return new LobbyViewModelFactory(loadCommonGreetingUseCase, loadLobbyGreetingUseCase, schedulersFacade);
    }
}
