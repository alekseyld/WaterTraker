package com.alekseyld.watertraker.ui.home

import com.alekseyld.watertraker.format
import com.alekseyld.watertraker.model.Day
import com.alekseyld.watertraker.model.Person
import com.alekseyld.watertraker.model.Sex
import com.alekseyld.watertraker.parseDate
import com.alekseyld.watertraker.service.IDayService
import com.alekseyld.watertraker.service.IPersonService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.nvtech.sedkp.base.BasePresenter
import java.util.*


class HomePresenter(private val personService: IPersonService,
                    private val dayService: IDayService)
    : BasePresenter<HomeContract.View>(), HomeContract.Presenter {

    private lateinit var person: Person

    private fun getPerson() {
        disposables.add(
            personService.get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        person = it

                        if (person.date != "") {
                            getCurrentDay()
                            viewMVP?.personSetted(true)
                        }

                        viewMVP?.personSetted(false)
                    },
                    {
                        it.printStackTrace()
                    }
                )
        )
    }

    private fun diffDate(first: Date, second: Date) : Int {
        val diff = first.time - second.time
        val seconds = diff / 1000
        val minutes = seconds / 60
        val hours = minutes / 60
        return (hours / 24).toInt()
    }

    private fun onCurrentDayUpdate(day: Day) {

        val personDate = person.date.parseDate()
        val currentDay = day.date.parseDate()

        val diff = diffDate(currentDay, personDate) + 1

        viewMVP?.fillDay(diff)
        viewMVP?.fillNorm(day.volume, person.norm)

        val procent = day.volume * 100 / person.norm

        viewMVP?.fillProcent(procent.format(0))

    }

    private fun subscribeOnCurrentDay() {
        disposables.add(
            dayService.currentDay()
                .subscribe { day ->
                    onCurrentDayUpdate(day)
                }
        )
    }

    override fun init() {
        getPerson()
    }

    override fun getSex(): Sex = person.sex

    private fun getCurrentDay() {
        disposables.add(
            dayService.getCurrent()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        subscribeOnCurrentDay()
                    },
                    {
                        it.printStackTrace()
                    }
                )
        )
    }

}