package ru.alekseyld.greenhouseapp.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun getSharedPreference(): SharedPreferences
    fun getApplicationContent(): Context
}