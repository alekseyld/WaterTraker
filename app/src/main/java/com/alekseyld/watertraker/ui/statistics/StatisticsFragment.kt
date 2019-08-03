package com.alekseyld.watertraker.ui.statistics

import android.os.Bundle
import android.view.View
import com.alekseyld.watertraker.App
import com.alekseyld.watertraker.R
import com.alekseyld.watertraker.model.Day
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.enums.Anchor
import com.anychart.enums.HoverMode
import com.anychart.enums.Position
import com.anychart.enums.TooltipPositionMode
import kotlinx.android.synthetic.main.fragment_statistics.*
import ru.nvtech.sedkp.base.BaseFragment


class StatisticsFragment : BaseFragment<StatisticsPresenter, StatisticsContract.View>(), StatisticsContract.View {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.setTitle(R.string.stats)
    }

    override fun onDayGetted(days: List<Day>) {

        setUpChart(bar_chart, days)

    }

    fun setUpChart(anyChartView: AnyChartView, days: List<Day>) {

        anyChartView.setProgressBar(progress)

        val cartesian = AnyChart.column()

        val data = ArrayList<DataEntry>()

        days.forEach {
            data.add(ValueDataEntry(it.date, it.volume))
        }

        val column = cartesian.column(data)

        column.tooltip()
            .titleFormat("{%X}")
            .position(Position.CENTER_BOTTOM)
            .anchor(Anchor.CENTER_BOTTOM)
            .offsetX(0.0)
            .offsetY(5.0)


        cartesian.yScale().minimum(0.0)

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT)
        cartesian.interactivity().hoverMode(HoverMode.BY_X)

        cartesian.xAxis(0).title("Дата")
        cartesian.yAxis(0).title("Литры")

        anyChartView.setChart(cartesian)
    }

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

    override fun attachView() {
        presenter.attachView(this)
        presenter.init()
    }
}