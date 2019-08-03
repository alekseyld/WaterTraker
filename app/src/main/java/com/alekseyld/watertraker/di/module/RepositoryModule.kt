package com.alekseyld.watertraker.di.module

import android.content.SharedPreferences
import com.alekseyld.watertraker.repository.IDayRepository
import com.alekseyld.watertraker.repository.IDrinkRepository
import com.alekseyld.watertraker.repository.IPersonRepository
import com.alekseyld.watertraker.repository.local.LocalDrinkRepository
import com.alekseyld.watertraker.repository.local.LocalPersonRepository
import com.alekseyld.watertraker.repository.local.RoomDayRepository
import com.alekseyld.watertraker.repository.room.DayDao
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Named("local")
    @Singleton
    @Provides
    fun getPersonRepository(sharedPreferences: SharedPreferences) : IPersonRepository {
        return LocalPersonRepository(sharedPreferences)
    }

    @Named("local")
    @Singleton
    @Provides
    fun getDayRepository(dayDao: DayDao) : IDayRepository {
        return RoomDayRepository(dayDao)
    }

    @Named("local")
    @Singleton
    @Provides
    fun getDrinkRepository() : IDrinkRepository {
        return LocalDrinkRepository()
    }

}