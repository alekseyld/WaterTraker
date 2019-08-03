package com.alekseyld.watertraker.ui.select_drink

import com.alekseyld.watertraker.model.Drink
import com.alekseyld.watertraker.service.IDrinkService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.nvtech.sedkp.base.BasePresenter

class SelectDrinkPresenter(private val drinkService: IDrinkService)
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}