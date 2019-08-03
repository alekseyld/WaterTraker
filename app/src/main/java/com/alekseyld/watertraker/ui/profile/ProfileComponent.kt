package com.alekseyld.watertraker.ui.profile

import com.alekseyld.watertraker.ui.home.HomeFragment
import dagger.Component
import ru.alekseyld.greenhouseapp.di.AppComponent
import ru.alekseyld.greenhouseapp.di.PerScreen

@PerScreen
@Component(modules = [(ProfileModule::class)], dependencies = [(AppComponent::class)])
interface ProfileComponent {
    fun inject(fragment: ProfileFragment)
}