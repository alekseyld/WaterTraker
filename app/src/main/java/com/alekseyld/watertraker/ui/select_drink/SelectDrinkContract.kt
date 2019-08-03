package com.alekseyld.watertraker.ui.select_drink

import com.alekseyld.watertraker.model.Drink

interface SelectDrinkContract {

    interface View {

        fun fillDrinks(drinks: List<Drink>)

    }

    interface Presenter {

        fun getDrinks()

    }

}