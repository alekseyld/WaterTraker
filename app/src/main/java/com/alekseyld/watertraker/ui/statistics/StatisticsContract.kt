package com.alekseyld.watertraker.ui.statistics

import com.alekseyld.watertraker.model.Day

interface StatisticsContract {

    interface View {

        fun onDayGetted(days: List<Day>)

    }

    interface Presenter {

        fun init()

    }

}