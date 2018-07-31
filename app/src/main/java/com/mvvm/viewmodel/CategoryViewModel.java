package com.mvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.mvvm.data.entity.DailyExerciseProgress;
import com.mvvm.data.repository.RoomRepository;

import java.util.List;

import javax.inject.Inject;

public class CategoryViewModel extends ViewModel {

    @Inject
    RoomRepository repository;

    public CategoryViewModel() {
    }

    public LiveData<List<DailyExerciseProgress>> getNextDays(int plan, boolean flag) {
        return repository.getDays();
    }
}
