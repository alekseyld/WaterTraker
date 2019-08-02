package ru.alekseyld.greenhouseapp.di

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    companion object {
        var PREFERENCE_NAME = "app_preference"
    }

    @Singleton
    @Provides
    fun provideContext(application: Application)
            = application.applicationContext

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context)
            = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

}