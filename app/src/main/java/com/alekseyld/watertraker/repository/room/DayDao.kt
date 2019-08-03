package com.alekseyld.watertraker.repository.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.alekseyld.watertraker.model.Day
import io.reactivex.Single

@Dao
interface DayDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(day: Day)

    @Query("SELECT * FROM day")
    fun getAll(): Single<List<Day>>

    @Query("SELECT * FROM day ORDER BY id asc LIMIT 5")
    fun getLastFive(): Single<List<Day>>

    @Query("SELECT * FROM day WHERE date = :currentDate")
    fun getCurrent(currentDate: String): Single<Day>

}