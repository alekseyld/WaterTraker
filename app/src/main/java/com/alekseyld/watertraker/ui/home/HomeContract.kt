package com.alekseyld.watertraker.ui.home

interface HomeContract {

    interface View {

        fun personSetted()

        fun fillDay(dayText: Int)
        fun fillNorm(from: Double, normText: Double)
        fun fillProcent(procentText: String)

    }

    interface Presenter {

        fun init()

    }
}