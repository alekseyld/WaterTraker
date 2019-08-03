package com.alekseyld.watertraker.ui.home

import com.alekseyld.watertraker.service.IPersonService
import dagger.Module
import dagger.Provides
import ru.alekseyld.greenhouseapp.di.PerScreen

@Module
class HomeModule {

    @PerScreen
    @Provides
    fun getPresenter(personService: IPersonService) = HomePresenter(personService)

}