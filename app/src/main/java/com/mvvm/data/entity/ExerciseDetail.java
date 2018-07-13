package com.mvvm.data.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by AdnanAli on 3/13/2018.
 */
@Entity(tableName = "exercise_detail", primaryKeys = {"exe_id", "lang_id"})
public class ExerciseDetail {

    @ColumnInfo(name = "exe_id")
    @SerializedName("exe_id")
    int exeId;

    @ColumnInfo(name = "lang_id")
    @SerializedName("lang_id")
    int langId;
    @ColumnInfo(name = "exe_type")
    @SerializedName("exe_type")
    int exeType;
    @ColumnInfo(name = "exe_name")
    @SerializedName("exe_name")
    String exeName;
    @ColumnInfo(name = "exe_url")
    @SerializedName("exe_url")
    String exeLink;
    @ColumnInfo(name = "exe_description")
    @SerializedName("exe_detail")
    String exeDescription;

    public ExerciseDetail() {
    }

    public int getExeType() {
        return exeType;
    }

    public void setExeType(int exeType) {
        this.exeType = exeType;
    }

    public String getExeName() {
        return exeName;
    }

    public void setExeName(String exeName) {
        this.exeName = exeName;
    }

    public String getExeLink() {
        return exeLink;
    }

    public void setExeLink(String exeLink) {
        this.exeLink = exeLink;
    }

    public int getLangId() {
        return langId;
    }


    public void setLangId(int langId) {
        this.langId = langId;
    }

    public int getExeId() {
        return exeId;
    }

    public void setExeId(int exeId) {
        this.exeId = exeId;
    }

    public String getExeDescription() {
        return exeDescription;
    }

    public void setExeDescription(String exeDescription) {
        this.exeDescription = exeDescription;
    }

}
