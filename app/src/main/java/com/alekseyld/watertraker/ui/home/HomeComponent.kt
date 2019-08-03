package com.alekseyld.watertraker.ui.home

import dagger.Component
import ru.alekseyld.greenhouseapp.di.AppComponent
import ru.alekseyld.greenhouseapp.di.PerScreen

@PerScreen
@Component(modules = [(HomeModule::class)], dependencies = [(AppComponent::class)])
interface HomeComponent {
    fun inject(fragment: HomeFragment)
}