package com.alekseyld.watertraker.ui.home

import com.alekseyld.watertraker.model.Sex

interface HomeContract {

    interface View {

        fun personSetted(set: Boolean)

        fun fillDay(dayText: Int)
        fun fillNorm(from: Double, normText: Double)
        fun fillProcent(procentText: String)

    }

    interface Presenter {

        fun init()
        fun getSex() : Sex

    }
}