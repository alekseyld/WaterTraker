package com.alekseyld.watertraker.ui.profile

import com.alekseyld.watertraker.calculateNorm
import com.alekseyld.watertraker.service.IPersonService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.nvtech.sedkp.base.BasePresenter

class ProfilePresenter(val personService: IPersonService)
    : BasePresenter<ProfileContract.View>(), ProfileContract.Presenter {

    override fun notifyUpdate() {

        val person = viewMVP!!.getNewPerson()

        person.norm = calculateNorm(person)

        viewMVP!!.updatePerson(person)

        disposables.add(
            personService.save(person)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        )
    }

    override fun getPerson() {
        disposables.add(
            personService.get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    viewMVP?.updatePerson(it)
                },
                    {
                        it.printStackTrace()
                    })
        )
    }
}