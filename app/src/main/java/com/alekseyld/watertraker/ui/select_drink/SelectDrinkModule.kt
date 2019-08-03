package com.alekseyld.watertraker.ui.select_drink

import dagger.Module
import dagger.Provides
import ru.alekseyld.greenhouseapp.di.PerScreen

@Module
class SelectDrinkModule {

    @PerScreen
    @Provides
    fun getPresenter() = SelectDrinkPresenter()

}