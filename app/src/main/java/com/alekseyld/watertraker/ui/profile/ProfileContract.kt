package com.alekseyld.watertraker.ui.profile

import com.alekseyld.watertraker.model.Person


interface ProfileContract {

    interface View {

        fun updatePerson(person: Person)
        fun updateNorm(norm: String)
        fun getNewPerson() : Person

    }

    interface Presenter {

        fun notifyUpdate()
        fun getPerson()

    }

}