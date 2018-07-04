package com.daggerandroidmvvm.view.activity;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.daggerandroidmvvm.R;
import com.daggerandroidmvvm.databinding.ActivityMainBinding;
import com.daggerandroidmvvm.helper.AppPreference;
import com.google.ads.consent.ConsentForm;
import com.google.ads.consent.ConsentInformation;

import java.text.DecimalFormat;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Inject
    AppPreference appPreference;
    DecimalFormat decimalFormat = new DecimalFormat("##.##");
    ConsentForm form;
    //  PlanDaysViewModel planDaysViewModel;
    ActivityMainBinding activityMainBinding;

    private float bmi;
    private String bmiUnit;
    private ConsentInformation consentInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //planDaysViewModel = ViewModelProviders.of(this).get(PlanDaysViewModel.class);

    }
}
