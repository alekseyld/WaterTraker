package com.alekseyld.watertraker.service

import com.alekseyld.watertraker.model.Drink

interface IDrinkService {

    fun getAll() : List<Drink>

}