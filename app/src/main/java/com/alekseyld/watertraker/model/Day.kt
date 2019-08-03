package com.alekseyld.watertraker.model

import java.util.*

data class Day (
    val date: Date,
    val drinks: List<Drink>,
    val volume: Double
)