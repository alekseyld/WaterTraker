package com.alekseyld.watertraker

import android.content.res.Resources
import com.alekseyld.watertraker.model.Person
import com.alekseyld.watertraker.model.Sex
import java.text.SimpleDateFormat
import java.util.*


fun calculateNorm(person: Person) : Double {

    val sex = if (person.sex == Sex.Female) 1.6
    else 1.7

    return sex + person.age * 0.0001 + person.height * 0.002 + person.weight * 0.004

}

fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)

fun String.parseDate() = SimpleDateFormat("dd.MM.yyyy").parse(this)

fun Date.format() = SimpleDateFormat("dd.MM.yyyy").format(this)

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()