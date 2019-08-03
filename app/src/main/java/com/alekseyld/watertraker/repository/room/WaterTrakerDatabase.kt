package com.alekseyld.watertraker.repository.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.alekseyld.watertraker.model.Day

@Database(entities = arrayOf(Day::class), version = 1, exportSchema = false)
abstract class WaterTrakerDatabase : RoomDatabase() {
    abstract fun dayDao(): DayDao
}