package com.alekseyld.watertraker.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "day")
data class Day (
    @PrimaryKey(autoGenerate = true) var id: Long = 0,

    val date: String,
    //val drinks: List<Drink>,
    var volume: Double
)