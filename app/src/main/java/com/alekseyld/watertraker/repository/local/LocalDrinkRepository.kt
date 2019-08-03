package com.alekseyld.watertraker.repository.local

import android.app.PendingIntent.getActivity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.support.v4.content.ContextCompat
import com.alekseyld.watertraker.R
import com.alekseyld.watertraker.model.Drink
import com.alekseyld.watertraker.repository.IDrinkRepository

class LocalDrinkRepository : IDrinkRepository {

    var list : List<Drink>? = null

    override fun getAll(): List<Drink> {
        if (list != null) return list!!

        val list = ArrayList<Drink>()

        list.add(Drink("Вода", null, 1f))
        list.add(Drink("Газированная вода", null, 0.8f))
        list.add(Drink("Кофе", null, 0.6f))
        list.add(Drink("Чай", null, 0.7f))

        return list
    }
}