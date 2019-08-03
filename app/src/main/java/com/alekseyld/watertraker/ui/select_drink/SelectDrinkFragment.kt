package com.alekseyld.watertraker.ui.select_drink

import android.os.Bundle
import android.view.View
import com.alekseyld.watertraker.App
import com.alekseyld.watertraker.R
import com.alekseyld.watertraker.model.Drink
import com.alekseyld.watertraker.ui.select_drink.select_doze.DrinksAdapter
import kotlinx.android.synthetic.main.fragment_select_drink.*
import ru.nvtech.sedkp.base.BaseBottomDialogFragment

class SelectDrinkFragment : BaseBottomDialogFragment<SelectDrinkPresenter, SelectDrinkContract.View>(), SelectDrinkContract.View {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun fillDrinks(drinks: List<Drink>) {
        drinks_recycler_view.adapter = DrinksAdapter(drinks)
        
    }

    override fun getLayoutId(): Int = R.layout.fragment_select_drink

    override fun injectDependencies() {
        DaggerSelectDrinkComponent.builder()
            .appComponent(App.component)
            .selectDrinkModule(SelectDrinkModule())
            .build()
            .inject(this)
    }

    override fun onBackKeyPressed() {
    }

    override fun attachView() {
        presenter.attachView(this)
        presenter.getDrinks()
    }
}