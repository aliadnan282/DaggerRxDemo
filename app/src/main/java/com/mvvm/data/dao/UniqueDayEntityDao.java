package com.mvvm.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.mvvm.data.entity.UniqueDayEntity;

import java.util.List;

/**
 * Created by AdnanAli on 3/12/2018.
 */

@Dao
public interface UniqueDayEntityDao {
    @Query("SELECT * FROM unique_day_entity")
    LiveData<List<UniqueDayEntity>> getAllUniqDayProgress();

    @Query("SELECT * FROM unique_day_entity order by day_id desc limit 30")
    LiveData<List<UniqueDayEntity>> getLast30DayProgress();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUniqueDay(UniqueDayEntity... uniqueDayEntities);


}
