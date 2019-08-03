package com.alekseyld.watertraker.ui.home

import android.os.Bundle
import android.view.View
import com.alekseyld.watertraker.App
import com.alekseyld.watertraker.R
import com.alekseyld.watertraker.ui.select_drink.SelectDrinkFragment
import kotlinx.android.synthetic.main.fragment_home.*
import ru.nvtech.sedkp.base.BaseFragment

class HomeFragment : BaseFragment<HomePresenter, HomeContract.View>(), HomeContract.View {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab.setOnClickListener {
            SelectDrinkFragment().show(fragmentManager, SelectDrinkFragment::class.java.name)
        }
    }

    override fun fillDay(dayText: String) {
        day.text = "День $dayText"
    }

    override fun fillNorm(from: String, normText: String) {
        norm.text = "$from из $normText л"
    }

    override fun fillProcent(procentText: String) {
        procent.text = "$procentText %"
    }

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun injectDependencies() {
        DaggerHomeComponent.builder()
            .appComponent(App.component)
            .homeModule(HomeModule())
            .build()
            .inject(this)
    }

    override fun onBackKeyPressed() {
    }

    override fun attachView() {
        presenter.attachView(this)
    }
}