package com.alekseyld.watertraker.repository

import com.alekseyld.watertraker.model.Day
import io.reactivex.Completable
import io.reactivex.Single

interface IDayRepository {

    fun update(day: Day) : Completable

    fun getCurrent() : Single<Day>

    fun getAll() : Single<List<Day>>

    fun getLastFive() : Single<List<Day>>

}