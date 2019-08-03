package com.alekseyld.watertraker.ui.select_drink

import android.app.AlertDialog
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.alekseyld.watertraker.App
import com.alekseyld.watertraker.R
import com.alekseyld.watertraker.format
import com.alekseyld.watertraker.model.Drink
import com.alekseyld.watertraker.ui.select_drink.select_doze.DrinksAdapter
import com.warkiz.widget.IndicatorSeekBar
import com.warkiz.widget.OnSeekChangeListener
import com.warkiz.widget.SeekParams
import kotlinx.android.synthetic.main.dialog_select_dose.view.*
import kotlinx.android.synthetic.main.fragment_select_drink.*
import kotlinx.android.synthetic.main.item_drink.view.name
import ru.nvtech.sedkp.base.BaseBottomDialogFragment

class SelectDrinkFragment : BaseBottomDialogFragment<SelectDrinkPresenter, SelectDrinkContract.View>(), SelectDrinkContract.View {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun fillDrinks(drinks: List<Drink>) {

        drinks.forEach {

            var id: Int? = when (it.name) {
                "Вода" -> R.drawable.water
                "Газированная вода" -> R.drawable.spart_water
                "Кофе" -> R.drawable.coffee
                "Чай" -> R.drawable.tea
                else -> null
            }

            id?.let { notNullId ->
                it.image = BitmapFactory.decodeResource(context?.resources, notNullId)
            }
        }

        drinks_recycler_view.adapter = DrinksAdapter(drinks, this::onDrinkSelected)
    }

    private fun onDrinkSelected(drink: Drink) {
        showSelectDozeDialog(drink)
    }

    private fun showSelectDozeDialog(drink: Drink) {

        val view = LayoutInflater.from(context).inflate(R.layout.dialog_select_dose, null)

        view.name.text = drink.name
        view.doze_text.text = "+ 0 мл"
        view.koef.text = "1 мл * ${drink.koef.format(1)}"

        view.doze.onSeekChangeListener = object : OnSeekChangeListener {
            override fun onSeeking(seekParams: SeekParams?) {}

            override fun onStartTrackingTouch(seekBar: IndicatorSeekBar?) {}

            override fun onStopTrackingTouch(seekBar: IndicatorSeekBar?) {
                view.doze_text.text = "+ ${seekBar?.progress} мл"
            }
        }

        AlertDialog.Builder(context)
            .setView(view)
            .setPositiveButton("Добавить") { _, _ ->
                drink.volume = view.doze.progress * 0.001
                presenter.addDrink(drink)
            }
            .setNegativeButton("Отмена") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
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