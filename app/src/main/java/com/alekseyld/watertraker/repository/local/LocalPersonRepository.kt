package com.alekseyld.watertraker.repository.local

import android.content.SharedPreferences
import com.alekseyld.watertraker.model.Person
import com.alekseyld.watertraker.model.sexFromInt
import com.alekseyld.watertraker.repository.IPersonRepository
import io.reactivex.Completable
import io.reactivex.Single

class LocalPersonRepository(private val sharedPreferences: SharedPreferences) : IPersonRepository {

    companion object {

        const val SEX_KEY = "sex"
        const val AGE_KEY = "age"
        const val HEIGHT_KEY = "height"
        const val WEIGHT_KEY = "weight"
        const val NORM_KEY = "norm"
        const val DATE_KEY = "date"

    }

    override fun getPerson(): Single<Person> {

        val sex = sexFromInt(sharedPreferences.getInt(SEX_KEY, 0))
        val age = sharedPreferences.getInt(AGE_KEY, 0)
        val height = sharedPreferences.getInt(HEIGHT_KEY, 0)
        val weight = sharedPreferences.getInt(WEIGHT_KEY, 0)
        val norm = sharedPreferences.getFloat(NORM_KEY, 0f)
        val date = sharedPreferences.getString(DATE_KEY, "")!!

        return Single.just(
            Person(sex = sex,
            age = age,
            height = height,
            weight = weight,
            norm = norm.toDouble(),
            date = date))
    }

    override fun savePerson(person: Person) : Completable {
        return Completable.fromAction {
            sharedPreferences.edit()
                .putInt(SEX_KEY, person.sex.toInt())
                .putInt(AGE_KEY, person.age)
                .putInt(HEIGHT_KEY, person.height)
                .putInt(WEIGHT_KEY, person.weight)
                .putFloat(NORM_KEY, person.norm.toFloat())
                .putString(DATE_KEY, person.date)
                .apply()
        }
    }
}