package com.alekseyld.watertraker.service.impl

import com.alekseyld.watertraker.model.Drink
import com.alekseyld.watertraker.repository.IDrinkRepository
import com.alekseyld.watertraker.service.IDrinkService
import io.reactivex.Single

class DrinkServiceImpl(private val drinkRepository: IDrinkRepository) : IDrinkService{

    override fun getAll(): Single<List<Drink>> = Single.just(drinkRepository.getAll())

}