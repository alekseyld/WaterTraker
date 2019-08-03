package com.alekseyld.watertraker.di.module

import com.alekseyld.watertraker.repository.IDayRepository
import com.alekseyld.watertraker.repository.IDrinkRepository
import com.alekseyld.watertraker.repository.IPersonRepository
import com.alekseyld.watertraker.service.IDayService
import com.alekseyld.watertraker.service.IDrinkService
import com.alekseyld.watertraker.service.IPersonService
import com.alekseyld.watertraker.service.impl.DayServiceImpl
import com.alekseyld.watertraker.service.impl.DrinkServiceImpl
import com.alekseyld.watertraker.service.impl.PersonServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ServiceModule {

    @Singleton
    @Provides
    fun getPersonService(@Named("local") personRepository: IPersonRepository) : IPersonService {
        return PersonServiceImpl(personRepository)
    }

    @Singleton
    @Provides
    fun getDayService(@Named("local") dayRepository: IDayRepository) : IDayService {
        return DayServiceImpl(dayRepository)
    }

    @Singleton
    @Provides
    fun getDrinkService(@Named("local") drinkRepository: IDrinkRepository) : IDrinkService {
        return DrinkServiceImpl(drinkRepository)
    }

}