package com.daggerandroidmvvm.data.pojo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;


import com.daggerandroidmvvm.data.entity.ExerciseDetail;
import com.daggerandroidmvvm.data.entity.PlanExercise;

import java.util.List;

public class CompleteExercise {
    @Embedded
    public PlanExercise planExercise;
    @Relation(parentColumn = "exe_id", entityColumn = "exe_id", entity = ExerciseDetail.class)
    public List<ExerciseDetail> getDayExerciseDetail;
}
