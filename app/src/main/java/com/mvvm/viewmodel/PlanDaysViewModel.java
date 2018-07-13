package com.mvvm.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.mvvm.common.domain.interactors.LoadCommonGreetingUseCase;
import com.mvvm.common.domain.interactors.LoadGreetingUseCase;
import com.mvvm.common.viewmodel.Response;
import com.mvvm.rx.SchedulersFacade;

import io.reactivex.disposables.CompositeDisposable;

public class PlanDaysViewModel extends ViewModel {

    private final LoadCommonGreetingUseCase loadCommonGreetingUseCase;


    private final SchedulersFacade schedulersFacade;

    private final CompositeDisposable disposables = new CompositeDisposable();

    public PlanDaysViewModel(LoadCommonGreetingUseCase loadCommonGreetingUseCase,
                      SchedulersFacade schedulersFacade) {
        this.loadCommonGreetingUseCase = loadCommonGreetingUseCase;
        this.schedulersFacade = schedulersFacade;
    }

    @Override
    protected void onCleared() {
        disposables.clear();
    }

    void loadCommonGreeting() {
        loadGreeting(loadCommonGreetingUseCase);
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

/*
package com.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;

import com.mvvm.data.entity.Achievement;
import com.mvvm.data.entity.DailyExerciseProgress;
import com.mvvm.data.entity.PlanExercise;
import com.mvvm.data.entity.UniqueDayEntity;
import com.mvvm.data.pojo.CompleteExercise;
import com.mvvm.data.repository.RoomRepository;
import com.mvvm.model.AchievementsDayProgress;

import java.util.List;

*/
/**
 * Created by AdnanAli on 3/12/2018.
 *//*


public class PlanDaysViewModel extends AndroidViewModel {


    private RoomRepository repository;
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.

    public PlanDaysViewModel(@NonNull Application application) {
        super(application);
        repository = RoomRepository.getInstance();

    }

    public List<DailyExerciseProgress> getSelectedPlanDaysSyn(int plan) {
        return repository.getAllDaysProgressSyn(plan);
    }

    public List<CompleteExercise> getDayExerciseDetail(int plan, int day) {

        return repository.getDayExerciseDetail(plan, day);
    }

    public LiveData<List<DailyExerciseProgress>> getNextDays(int plan, boolean flag) {
        return repository.getNextdDays(plan, flag);
    }

    public LiveData<List<DailyExerciseProgress>> getDaysProgress(int plan) {
        return repository.getAllDaysProgress(plan);
    }


    public void updateDay(PlanExercise planExercise) {
        repository.updateDay(planExercise);
    }

    public void updateDailyExerciseProgress(DailyExerciseProgress dailyExerciseProgress) {
        repository.updateDailyExerciseProgress(dailyExerciseProgress);
    }

    public void updateAllDailyProgress(List<DailyExerciseProgress> dailyExerciseProgress) {
        repository.updateAllDailyExerciseProgress(dailyExerciseProgress);
    }

    public LiveData<List<AchievementsDayProgress>> getAchievementProgress() {
        return repository.getAchievementProgress();
    }

    public void updateAchievement(Achievement achievement) {
        repository.updateAchievement(achievement);
    }

    public List<Achievement> getAllAchievements() {
        return repository.getAllAchievements();
    }

    public LiveData<List<UniqueDayEntity>> getAllUniqueDay() {
        return repository.getAllUniqueDay();
    }
}
*/
