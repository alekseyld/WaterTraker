package com.alekseyld.watertraker.repository.local

import com.alekseyld.watertraker.format
import com.alekseyld.watertraker.model.Day
import com.alekseyld.watertraker.repository.IDayRepository
import com.alekseyld.watertraker.repository.room.DayDao
import io.reactivex.Completable
import io.reactivex.Single
import java.util.*

class RoomDayRepository(private val dayDao: DayDao) : IDayRepository {

    override fun update(day: Day): Completable {
        return Completable.fromAction {
            dayDao.insertOrUpdate(day)
        }
    }

    override fun getCurrent(): Single<Day> {
        return dayDao.getCurrent(Date().format())
            .onErrorResumeNext {
                return@onErrorResumeNext Single.just(Day(date = "", volume = .0, id = -1L))
            }.flatMap {
                if (it.id != -1L && it.date != "") return@flatMap Single.just(it)

                val day = Day(date = Date().format(), volume = .0)

                return@flatMap update(day)
                    .toSingle { day }
            }
    }

    override fun getAll(): Single<List<Day>> = dayDao.getAll()

    override fun getLastFive(): Single<List<Day>> = dayDao.getLastFive()
}
