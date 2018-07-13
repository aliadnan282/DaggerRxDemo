package com.mvvm.manager;

import android.util.Log;

import com.mvvm.data.entity.ExerciseDetail;
import com.mvvm.helper.AppConstant;
import com.mvvm.model.Day;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

import static com.mvvm.helper.AppConstant.EXERCISE_JSON_PATH;
import static com.mvvm.helper.AppConstant.WORKOUT_PLAN_PATH;

/**
 * Created by AdnanAli on 1/29/2018.
 */

public class JsonManager {
    public static JsonManager ourInstance;
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    private JsonManager() {
    }

    public static JsonManager getInstance() {
        if (ourInstance == null)
            ourInstance = new JsonManager();

        return ourInstance;
    }

 /*   public static String m24329a(int i) {
        switch (i) {
            case 24:
                return "json/abs/all_levels.json";
            case 25:
                return "json/shoulder_back/all_levels.json";
            case 26:
                return "json/leg/all_levels.json";
            default:
                return "json/arm_chest/all_levels.json";
        }
    }*/

    public static String loadJSONFromAsset(String fileName) {
        String json;
        try {
            InputStream is = AppConstant.mContext.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            Log.d("JSON READ", "loadJSONFromAsset: " + json);
        } catch (IOException ex) {
            return null;
        }
        return json;
    }

    public List<Day> getPlanExercise() {
        String exerciseJson = loadJSONFromAsset(WORKOUT_PLAN_PATH);
        Type listType = new TypeToken<List<Day>>() {
        }.getType();
        List<Day> yourList = new Gson().fromJson(exerciseJson, listType);
        return yourList;
    }

    public List<ExerciseDetail> getExerciseDetailList() {

       /* Gson gson = new Gson();
        Type type = new TypeToken<List<ContactModel>>(){}.getType();
        List<ContactModel> contactList = gson.fromJson(jsonString, type);
        for (ContactModel contact : contactList){
            Log.i("Contact Details", contact.id + "-" + contact.name + "-" + contact.email);
        }*/


        String exerciseJson = loadJSONFromAsset(EXERCISE_JSON_PATH);
        Type listType = new TypeToken<List<ExerciseDetail>>() {
        }.getType();
        List<ExerciseDetail> yourList = new Gson().fromJson(exerciseJson, listType);
        Log.d("size", ": " + yourList.size());

        return yourList;
    }
}