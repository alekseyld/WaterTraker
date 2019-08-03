package com.alekseyld.watertraker.repository

import com.alekseyld.watertraker.model.Person

interface IPersonRepository {

    fun getPerson() : Person
    fun savePerson(person: Person)

}