package com.alekseyld.watertraker.ui.statistics

import com.alekseyld.watertraker.App
import com.alekseyld.watertraker.R
import ru.nvtech.sedkp.base.BaseFragment

class StatisticsFragment : BaseFragment<StatisticsPresenter, StatisticsContract.View>(), StatisticsContract.View {

    override fun getLayoutId(): Int = R.layout.fragment_statistics

    override fun injectDependencies() {
        DaggerStatisticsComponent.builder()
            .appComponent(App.component)
            .statisticsModule(StatisticsModule())
            .build()
            .inject(this)
    }

    override fun onBackKeyPressed() {
    }
}