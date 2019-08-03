package com.alekseyld.watertraker.repository

import com.alekseyld.watertraker.model.Drink

interface IDrinkRepository {

    fun getAll() : List<Drink>

}