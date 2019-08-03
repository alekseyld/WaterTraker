package com.alekseyld.watertraker.ui.home

interface HomeContract {

    interface View {

        fun fillDay(dayText: String)
        fun fillNorm(from: String, normText: String)
        fun fillProcent(procentText: String)

    }

    interface Presenter {

    }
}