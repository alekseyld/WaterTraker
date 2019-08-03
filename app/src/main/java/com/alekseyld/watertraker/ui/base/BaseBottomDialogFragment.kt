package ru.nvtech.sedkp.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import javax.inject.Inject

abstract class BaseBottomDialogFragment<TPresenter : MvpPresenter<TView>, TView> : BottomSheetDialogFragment() {
    var isFirstLoad = true

    @Inject
    protected lateinit var presenter: TPresenter

    val inject by lazy { injectDependencies() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getLayoutId(), container, false)
        inject
        attachView()
        return view
    }

    abstract fun attachView()

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

    override fun onPause() {
        presenter.pause()
        super.onPause()
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }


    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun injectDependencies()

    abstract fun onBackKeyPressed()

}