package com.alekseyld.watertraker.service

import com.alekseyld.watertraker.model.Drink
import io.reactivex.Single

interface IDrinkService {

    fun getAll() : Single<List<Drink>>

}