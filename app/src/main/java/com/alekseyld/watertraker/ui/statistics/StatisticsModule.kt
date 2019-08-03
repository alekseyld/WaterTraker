package com.alekseyld.watertraker.ui.statistics

import com.alekseyld.watertraker.service.IDayService
import dagger.Module
import dagger.Provides
import ru.alekseyld.greenhouseapp.di.PerScreen

@Module
class StatisticsModule {

    @PerScreen
    @Provides
    fun getPresenter(dayService: IDayService) = StatisticsPresenter(dayService)

}