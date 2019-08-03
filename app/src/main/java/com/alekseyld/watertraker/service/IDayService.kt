package com.alekseyld.watertraker.service

import com.alekseyld.watertraker.model.Day
import com.alekseyld.watertraker.model.Drink
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.subjects.Subject


interface IDayService {

    fun currentDay() : Subject<Day>

    fun update(day: Day) : Completable

    fun getCurrent() : Single<Day>

    fun getAll() : Single<List<Day>>

    fun addDrinkToCurrentDay(drink: Drink) : Completable

}