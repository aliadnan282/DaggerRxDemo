package com.mvvm.data.pojo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;


import com.mvvm.data.entity.ExerciseDetail;
import com.mvvm.data.entity.PlanExercise;

import java.util.List;

public class CompleteExercise {
    @Embedded
    public PlanExercise planExercise;
    @Relation(parentColumn = "exe_id", entityColumn = "exe_id", entity = ExerciseDetail.class)
    public List<ExerciseDetail> getDayExerciseDetail;
}
