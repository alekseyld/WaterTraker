package com.alekseyld.watertraker.ui.select_drink.select_doze

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alekseyld.watertraker.R
import com.alekseyld.watertraker.model.Drink
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_drink.*

class DrinksAdapter(private val drinks: List<Drink>,
                    private val callback: (Drink) -> Unit)
    : RecyclerView.Adapter<DrinksAdapter.DrinkViewHolder>() {

    inner class DrinkViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun setDrink(drink: Drink) {

            image.setImageBitmap(drink.image)
            name.text = drink.name.replace(" ", "\n")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_drink, parent, false)
        return DrinkViewHolder(v)
    }

    override fun getItemCount() = drinks.count()

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {

        holder.setDrink(drinks[position])

        holder.containerView.setOnClickListener {
            callback(drinks[position])
        }
    }
}