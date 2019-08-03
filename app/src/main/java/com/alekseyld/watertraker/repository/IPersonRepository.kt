package com.alekseyld.watertraker.repository

import com.alekseyld.watertraker.model.Person
import io.reactivex.Completable
import io.reactivex.Single

interface IPersonRepository {

    fun getPerson() : Single<Person>
    fun savePerson(person: Person) : Completable

}