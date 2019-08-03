package com.alekseyld.watertraker.di.module

import android.content.SharedPreferences
import com.alekseyld.watertraker.repository.IPersonRepository
import com.alekseyld.watertraker.repository.local.LocalPersonRepository
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

}