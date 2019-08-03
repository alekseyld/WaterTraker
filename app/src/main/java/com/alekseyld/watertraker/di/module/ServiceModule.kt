package com.alekseyld.watertraker.di.module

import com.alekseyld.watertraker.repository.IPersonRepository
import com.alekseyld.watertraker.service.IPersonService
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

}