package com.alekseyld.watertraker.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import com.alekseyld.watertraker.App
import com.alekseyld.watertraker.R
import com.alekseyld.watertraker.format
import com.alekseyld.watertraker.model.Sex
import com.alekseyld.watertraker.ui.MainActivity
import com.alekseyld.watertraker.ui.select_drink.SelectDrinkFragment
import kotlinx.android.synthetic.main.fragment_home.*
import ru.nvtech.sedkp.base.BaseFragment

class HomeFragment : BaseFragment<HomePresenter, HomeContract.View>(), HomeContract.View {

    @SuppressLint("RestrictedApi")
    override fun personSetted(set: Boolean) {

        if (set) {
            cardView.visibility = View.VISIBLE
            man.visibility = View.VISIBLE
            fab.visibility = View.VISIBLE

            wall.visibility = View.GONE

            if (presenter.getSex() == Sex.Female) {
                man.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.woman))
            } else {
                man.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.man))
            }

        } else
        {
            wall.animate().alpha(1.0f).setDuration(1000)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab.setOnClickListener {
            SelectDrinkFragment().show(fragmentManager, SelectDrinkFragment::class.java.name)
        }

        submit.setOnClickListener {
            (activity as? MainActivity)?.toProfile()
        }
    }

    override fun fillDay(dayText: Int) {
        day?.text = "День $dayText"
    }

    override fun fillNorm(from: Double, normText: Double) {
        norm?.text = "${from.format(2)} из ${normText.format(2)} л"
    }

    override fun fillProcent(procentText: String) {
        procent?.text = "$procentText %"
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
        presenter.init()
    }
}