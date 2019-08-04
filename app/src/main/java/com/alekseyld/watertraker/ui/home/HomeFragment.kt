package com.alekseyld.watertraker.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.view.View
import com.alekseyld.watertraker.App
import com.alekseyld.watertraker.R
import com.alekseyld.watertraker.format
import com.alekseyld.watertraker.model.Sex
import com.alekseyld.watertraker.px
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
                man.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.woman_reverse))
            } else {
                man.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.man_reverse))
            }

            man.invalidate()
        } else
        {
            wall.animate().alpha(1.0f).duration = 1000
        }
    }

    private fun setHeight(view: View, height: Int) {
        val params = view.layoutParams as ConstraintLayout.LayoutParams
        params.height = height.px
        view.layoutParams = params
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.title = getString(R.string.home_title)

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
        val n = "${from.format(2)} из ${normText.format(2)} л"

        norm?.text = n

        (activity as? MainActivity)?.fillNorm(n)
    }

    override fun fillProcent(procentText: String) {
        procent?.text = "$procentText %"

        calculateMan(procentText.toInt())
    }

    private fun calculateMan(procent: Int) {
        val height = Math.min(procent * 485 / 100, 480)
        setHeight(water_up, height)
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