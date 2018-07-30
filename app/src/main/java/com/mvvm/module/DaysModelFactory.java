/*
package com.mvvm.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.mvvm.common.domain.interactors.LoadCommonGreetingUseCase;
import com.mvvm.rx.SchedulersFacade;

public class DaysModelFactory implements ViewModelProvider.Factory {

    private final LoadCommonGreetingUseCase loadCommonGreetingUseCase;


    private final SchedulersFacade schedulersFacade;

    DaysModelFactory(LoadCommonGreetingUseCase loadCommonGreetingUseCase,
                     SchedulersFacade schedulersFacade) {
        this.loadCommonGreetingUseCase = loadCommonGreetingUseCase;
        this.schedulersFacade = schedulersFacade;
    }

    @Override
public <T extends ViewModel> T create(Class<T> modelClass) {
    if (modelClass.isAssignableFrom(PlanDaysViewModel.class)) {
        return (T) new PlanDaysViewModel(loadCommonGreetingUseCase , schedulersFacade);
    }
    throw new IllegalArgumentException("Unknown ViewModel class");
}
}
*/
