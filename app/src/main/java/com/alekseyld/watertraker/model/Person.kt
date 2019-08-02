package com.alekseyld.watertraker.model

enum class Sex {
    Male, Female;

    fun toInt() : Int {
        return when (this){
            Male -> 0
            Female -> 1
        }
    }
}

fun sexFromInt(num: Int) : Sex {
    return when (num) {
        1 -> Sex.Female
        else -> Sex.Male
    }
}

data class Person(val sex: Sex,
                  val height: Int,
                  val weight: Int,
                  val age: Int)