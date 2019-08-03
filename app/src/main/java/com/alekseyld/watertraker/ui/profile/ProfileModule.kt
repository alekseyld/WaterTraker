package com.alekseyld.watertraker.ui.profile

import com.alekseyld.watertraker.service.IPersonService
import dagger.Module
import dagger.Provides
import ru.alekseyld.greenhouseapp.di.PerScreen

@Module
class ProfileModule {

    @PerScreen
    @Provides
    fun getPresenter(personService: IPersonService) = ProfilePresenter(personService)

}