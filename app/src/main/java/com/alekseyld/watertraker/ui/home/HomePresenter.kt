package com.alekseyld.watertraker.ui.home

import com.alekseyld.watertraker.service.IPersonService
import ru.nvtech.sedkp.base.BasePresenter

class HomePresenter(private val personService: IPersonService)
    : BasePresenter<HomeContract.View>(), HomeContract.Presenter {



}