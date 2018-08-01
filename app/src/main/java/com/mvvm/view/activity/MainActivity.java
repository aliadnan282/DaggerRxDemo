package com.mvvm.view.activity;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.ads.consent.ConsentForm;
import com.google.ads.consent.ConsentInformation;
import com.mvvm.R;
import com.mvvm.data.entity.DailyExerciseProgress;
import com.mvvm.databinding.ActivityMainBinding;
import com.mvvm.helper.AppPreference;
import com.mvvm.helper.SixPackThreadPoolExecutor;
import com.mvvm.module.DaysModelFactory;
import com.mvvm.viewmodel.CategoryViewModel;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Inject
    AppPreference appPreference;
    /*   @Inject
       RoomRepository repository;*/
    @Inject
    DaysModelFactory daysModelFactory;

    DecimalFormat decimalFormat = new DecimalFormat("##.##");
    ConsentForm form;
    ActivityMainBinding activityMainBinding;
    CategoryViewModel categoryViewModel;

    private float bmi;
    private String bmiUnit;
    private ConsentInformation consentInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        List<DailyExerciseProgress> list = new ArrayList<>();
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        categoryViewModel = ViewModelProviders.of(this, daysModelFactory).get(CategoryViewModel.class);
        categoryViewModel.getNextDays(1, false).observe(this, dailyExerciseProgresses -> Toast.makeText(this, "hello size=" + dailyExerciseProgresses.get(0).getDayId(), Toast.LENGTH_SHORT).show());
        Observable.fromCallable(() -> {
            for (int i = 0; i < 10; i++) {
                list.add(new DailyExerciseProgress(1, i * 2, false));
            }
            categoryViewModel.insertData(list);
            return true;
        }).subscribeOn(Schedulers.from(SixPackThreadPoolExecutor.getInstance()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((result) -> {
                    categoryViewModel.getNextDays(1,false).observe(this, dailyExerciseProgresses -> {
                        Toast.makeText(this, "Hi" + dailyExerciseProgresses.size(), Toast.LENGTH_SHORT).show();

                    });
                });
        // planDaysViewModel = ViewModelProviders.of(this, viewModelFactory).get(PlanDaysViewModel.class);

        // planDaysViewModel.response().observe(this, response -> processResponse(response));

    }
}
