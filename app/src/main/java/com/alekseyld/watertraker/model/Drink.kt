package com.alekseyld.watertraker.model

import android.graphics.Bitmap

data class Drink(val name: String,
                 var image: Bitmap?,
                 val koef: Double,
                 var volume: Int? = 0)