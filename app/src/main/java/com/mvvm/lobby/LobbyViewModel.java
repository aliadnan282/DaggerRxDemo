package com.mvvm.lobby;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.mvvm.common.domain.interactors.LoadCommonGreetingUseCase;
import com.mvvm.common.domain.interactors.LoadGreetingUseCase;
import com.mvvm.common.viewmodel.Response;
import com.mvvm.rx.SchedulersFacade;

import io.reactivex.disposables.CompositeDisposable;

class LobbyViewModel extends ViewModel {

    private final LoadCommonGreetingUseCase loadCommonGreetingUseCase;

    private final LoadLobbyGreetingUseCase loadLobbyGreetingUseCase;

    private final SchedulersFacade schedulersFacade;

    private final CompositeDisposable disposables = new CompositeDisposable();

    private final MutableLiveData<Response> response = new MutableLiveData<>();

    LobbyViewModel(LoadCommonGreetingUseCase loadCommonGreetingUseCase,
                          LoadLobbyGreetingUseCase loadLobbyGreetingUseCase,
                          SchedulersFacade schedulersFacade) {
        this.loadCommonGreetingUseCase = loadCommonGreetingUseCase;
        this.loadLobbyGreetingUseCase = loadLobbyGreetingUseCase;
        this.schedulersFacade = schedulersFacade;
    }

    @Override
    protected void onCleared() {
        disposables.clear();
    }

    void loadCommonGreeting() {
        loadGreeting(loadCommonGreetingUseCase);
    }

    void loadLobbyGreeting() {
        loadGreeting(loadLobbyGreetingUseCase);
    }

    MutableLiveData<Response> response() {
        return response;
    }

    private void loadGreeting(LoadGreetingUseCase loadGreetingUseCase) {
        disposables.add(loadGreetingUseCase.execute()
                .subscribeOn(schedulersFacade.io())
                .observeOn(schedulersFacade.ui())
                .doOnSubscribe(__ -> response.setValue(Response.loading()))
                .subscribe(
                        greeting -> response.setValue(Response.success(greeting)),
                        throwable -> response.setValue(Response.error(throwable))
                )
        );
    }
}
