package com.alekseyld.watertraker.ui.home

import dagger.Module
import dagger.Provides
import ru.alekseyld.greenhouseapp.di.PerScreen

@Module
class HomeModule {

    @PerScreen
    @Provides
    fun getPresenter() = HomePresenter()

}