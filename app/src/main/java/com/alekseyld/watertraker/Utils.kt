package com.alekseyld.watertraker

import com.alekseyld.watertraker.model.Person
import com.alekseyld.watertraker.model.Sex


fun calculateNorm(person: Person) : Double {

    val sex = if (person.sex == Sex.Female) 1.6
    else 1.7

    return sex + person.age * 0.0001 + person.height * 0.002 + person.weight * 0.004

}

fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)