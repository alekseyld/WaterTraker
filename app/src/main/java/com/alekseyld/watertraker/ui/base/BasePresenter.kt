package ru.nvtech.sedkp.base

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<TView> : MvpPresenter<TView> {

    protected val tag: String = this.javaClass.simpleName

    protected var viewMVP: TView? = null
        private set

    override fun resume() {

    }

    override fun pause() {

    }

    override fun destroy() {
        this.viewMVP = null
    }

    override fun attachView(view: TView) {
        this.viewMVP = view
    }
}