package com.alekseyld.watertraker.service

import com.alekseyld.watertraker.model.Person


interface IPersonService {

    fun save(person: Person)

    fun get() : Person

}