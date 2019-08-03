package com.alekseyld.watertraker.repository.local

import com.alekseyld.watertraker.model.Drink
import com.alekseyld.watertraker.repository.IDrinkRepository

class LocalDrinkRepository : IDrinkRepository {

    var list : List<Drink>? = null

    override fun getAll(): List<Drink> {
        if (list != null) return list!!

        val list = ArrayList<Drink>()

        list.add(Drink("Вода", null, 1.0))
        list.add(Drink("Газированная вода", null, 0.8))
        list.add(Drink("Кофе", null, 0.6))
        list.add(Drink("Чай", null, 0.7))

        return list
    }
}