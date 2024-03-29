package ru.nvtech.sedkp.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import javax.inject.Inject

abstract class BaseFragment<TPresenter : MvpPresenter<TView>, TView> : Fragment() {

    var isNotFirstLoad = false

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

    protected open fun hideKeyboard() {
        if (activity!!.currentFocus == null) return
        val imm = activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.hideSoftInputFromWindow(activity?.currentFocus?.windowToken, 0)
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun injectDependencies()

    abstract fun onBackKeyPressed()

}