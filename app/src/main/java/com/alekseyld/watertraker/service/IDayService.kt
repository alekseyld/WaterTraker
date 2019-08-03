package com.alekseyld.watertraker.service

import com.alekseyld.watertraker.model.Day

interface IDayService {

    fun update(day: Day)

    fun getCurrent() : Day

    fun getAll() : List<Day>

}