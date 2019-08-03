package com.alekseyld.watertraker.service.impl

import com.alekseyld.watertraker.model.Person
import com.alekseyld.watertraker.model.Sex
import com.alekseyld.watertraker.service.IPersonService

class PersonServiceImpl : IPersonService {

    var mock_person = Person(sex = Sex.Male, age = 20, height = 190, weight = 61)

    override fun save(person: Person) {

        mock_person = person

    }

    override fun get(): Person {

        return mock_person


    }
}