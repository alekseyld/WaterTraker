package com.alekseyld.watertraker.ui.select_drink

import dagger.Component
import ru.alekseyld.greenhouseapp.di.AppComponent
import ru.alekseyld.greenhouseapp.di.PerScreen

@PerScreen
@Component(modules = [(SelectDrinkModule::class)], dependencies = [(AppComponent::class)])
interface SelectDrinkComponent {
    fun inject(fragment: SelectDrinkFragment)
}