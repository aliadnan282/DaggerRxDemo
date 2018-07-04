package com.daggerandroidmvvm.model;

public class AchievementsDayProgress {

    private String latest_date;
    private int day_counter;

    public AchievementsDayProgress(String latest_date, int day_counter) {
        this.latest_date = latest_date;
        this.day_counter = day_counter;
    }

    public String getLatest_date() {
        return latest_date;
    }

    public void setLatest_date(String latest_date) {
        this.latest_date = latest_date;
    }

    public int getDay_counter() {
        return day_counter;
    }

    public void setDay_counter(int day_counter) {
        this.day_counter = day_counter;
    }

}