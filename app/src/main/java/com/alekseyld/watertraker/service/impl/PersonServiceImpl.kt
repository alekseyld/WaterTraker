package com.alekseyld.watertraker.service.impl

import com.alekseyld.watertraker.model.Person
import com.alekseyld.watertraker.repository.IPersonRepository
import com.alekseyld.watertraker.service.IPersonService
import io.reactivex.Completable
import io.reactivex.Single

class PersonServiceImpl(private val personRepository: IPersonRepository) : IPersonService {

    override fun save(person: Person) : Completable = personRepository.savePerson(person)

    override fun get(): Single<Person> = personRepository.getPerson()

}