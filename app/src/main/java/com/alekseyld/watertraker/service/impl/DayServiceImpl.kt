package com.alekseyld.watertraker.service.impl

import com.alekseyld.watertraker.model.Day
import com.alekseyld.watertraker.model.Drink
import com.alekseyld.watertraker.repository.IDayRepository
import com.alekseyld.watertraker.service.IDayService
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject

class DayServiceImpl(private val dayRepository: IDayRepository) : IDayService {

    private val currentDay = BehaviorSubject.create<Day>()

    override fun currentDay(): Subject<Day> = currentDay

    override fun update(day: Day) : Completable = dayRepository.update(day)

    override fun getCurrent(): Single<Day>
            = dayRepository.getCurrent()
                .map {
                    currentDay.onNext(it)
                    return@map it
                }

    override fun getAll(): Single<List<Day>> = dayRepository.getAll()

    override fun addDrinkToCurrentDay(drink: Drink): Completable {
        currentDay.value!!.volume += drink.volume!!
        currentDay.onNext(currentDay.value!!)
        return dayRepository.update(currentDay.value!!)
    }
}