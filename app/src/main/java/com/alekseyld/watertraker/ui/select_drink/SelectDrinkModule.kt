package com.alekseyld.watertraker.ui.select_drink

import com.alekseyld.watertraker.service.IDrinkService
import dagger.Module
import dagger.Provides
import ru.alekseyld.greenhouseapp.di.PerScreen

@Module
class SelectDrinkModule {

    @PerScreen
    @Provides
    fun getPresenter(drinkService: IDrinkService) = SelectDrinkPresenter(drinkService)

}