package com.mvvm.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.mvvm.viewmodel.CategoryViewModel;

import javax.inject.Inject;

public class DaysModelFactory implements ViewModelProvider.Factory {

    @Inject
    DaysModelFactory() {
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CategoryViewModel.class)) {
            return (T) new CategoryViewModel();
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
