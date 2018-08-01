package com.mvvm.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.mvvm.data.repository.RoomRepository;
import com.mvvm.viewmodel.CategoryViewModel;

import javax.inject.Inject;

public class DaysModelFactory implements ViewModelProvider.Factory {

    private RoomRepository roomRepository;


    DaysModelFactory( RoomRepository roomRepository) {
        this.roomRepository=roomRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CategoryViewModel.class)) {
            return (T) new CategoryViewModel(roomRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
