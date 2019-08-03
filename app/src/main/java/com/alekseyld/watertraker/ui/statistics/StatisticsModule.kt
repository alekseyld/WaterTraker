package com.alekseyld.watertraker.ui.statistics

import com.alekseyld.watertraker.ui.home.HomePresenter
import dagger.Module
import dagger.Provides
import ru.alekseyld.greenhouseapp.di.PerScreen

@Module
class StatisticsModule {

    @PerScreen
    @Provides
    fun getPresenter() = StatisticsPresenter()

}