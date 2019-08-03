package ru.alekseyld.greenhouseapp.di

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.alekseyld.watertraker.repository.room.DayDao
import com.alekseyld.watertraker.repository.room.WaterTrakerDatabase
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

    @Singleton
    @Provides
    fun provideDataBase(context: Context): WaterTrakerDatabase =
        Room.databaseBuilder(context, WaterTrakerDatabase::class.java, "waterdb")
            .build()

    @Singleton
    @Provides
    fun provideDayDao(db: WaterTrakerDatabase): DayDao = db.dayDao()
}