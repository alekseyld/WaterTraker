package com.alekseyld.watertraker.ui.statistics

import com.alekseyld.watertraker.service.IDayService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.nvtech.sedkp.base.BasePresenter

class StatisticsPresenter(private val dayService: IDayService)
    : BasePresenter<StatisticsContract.View>(), StatisticsContract.Presenter {

    override fun init() {
        disposables.add(
            dayService.getLastFive()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        viewMVP?.onDayGetted(it)
                    },
                    {
                        it.printStackTrace()
                    }
                )
        )
    }
}