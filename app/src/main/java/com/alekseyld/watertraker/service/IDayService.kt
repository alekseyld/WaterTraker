package com.alekseyld.watertraker.service

import com.alekseyld.watertraker.model.Day
import io.reactivex.Single

interface IDayService {

    fun update(day: Day)

    fun getCurrent() : Single<Day>

    fun getAll() : Single<List<Day>>

}