package com.alekseyld.watertraker.ui.statistics

import dagger.Component
import ru.alekseyld.greenhouseapp.di.AppComponent
import ru.alekseyld.greenhouseapp.di.PerScreen

@PerScreen
@Component(modules = [(StatisticsModule::class)], dependencies = [(AppComponent::class)])
interface StatisticsComponent {
    fun inject(fragment: StatisticsFragment)
}