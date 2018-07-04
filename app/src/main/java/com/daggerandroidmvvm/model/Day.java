package com.daggerandroidmvvm.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Day {
    int dayId;
    int planId;
    @SerializedName("exercise")
    private List<Exercise> exerciseList = new ArrayList<>();

    public int getPlanId() {
        return planId;
    }

    public int getDayId() {
        return dayId;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }
}

	