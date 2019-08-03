package com.alekseyld.watertraker.ui.select_drink

import com.alekseyld.watertraker.model.Drink
import com.alekseyld.watertraker.service.IDayService
import com.alekseyld.watertraker.service.IDrinkService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.nvtech.sedkp.base.BasePresenter

class SelectDrinkPresenter(private val drinkService: IDrinkService,
                           private val dayService: IDayService)
    : BasePresenter<SelectDrinkContract.View>(), SelectDrinkContract.Presenter {

    override fun getDrinks() {
        disposables.add(
            drinkService.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        viewMVP?.fillDrinks(it)
                    },
                    {
                      it.printStackTrace()
                    }
                )
        )
    }

    override fun addDrink(drink: Drink) {
        disposables.add(
            dayService.addDrinkToCurrentDay(drink)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {

                    },
                    {
                        it.printStackTrace()
                    }
                )
        )
    }
}