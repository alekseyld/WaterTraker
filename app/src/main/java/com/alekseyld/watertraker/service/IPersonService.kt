package com.alekseyld.watertraker.service

import com.alekseyld.watertraker.model.Person
import io.reactivex.Completable
import io.reactivex.Single


interface IPersonService {

    fun save(person: Person) : Completable

    fun get() : Single<Person>

}