package com.alekseyld.watertraker.service.impl

import com.alekseyld.watertraker.model.Day
import com.alekseyld.watertraker.repository.IDayRepository
import com.alekseyld.watertraker.service.IDayService
import io.reactivex.Single

class DayServiceImpl(private val dayRepository: IDayRepository) : IDayService {

    override fun update(day: Day) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrent(): Single<Day> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAll(): Single<List<Day>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}