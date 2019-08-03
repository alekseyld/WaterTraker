package com.alekseyld.watertraker.ui.profile

import android.os.Bundle
import android.view.View
import com.alekseyld.watertraker.App
import com.alekseyld.watertraker.R
import com.alekseyld.watertraker.format
import com.alekseyld.watertraker.model.Person
import com.alekseyld.watertraker.model.Sex
import com.alekseyld.watertraker.ui.MainActivity
import com.warkiz.widget.IndicatorSeekBar
import com.warkiz.widget.OnSeekChangeListener
import com.warkiz.widget.SeekParams
import kotlinx.android.synthetic.main.fragment_profile.*
import ru.nvtech.sedkp.base.BaseFragment
import java.util.*

class ProfileFragment : BaseFragment<ProfilePresenter, ProfileContract.View>(), ProfileContract.View {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.title = getString(R.string.title_profile)

        presenter.getPerson()
    }

    private fun setUpListeners() {
        addListenerOnButton()

        val listener = object : OnSeekChangeListener {
            override fun onSeeking(seekParams: SeekParams?) {}

            override fun onStartTrackingTouch(seekBar: IndicatorSeekBar?) {}

            override fun onStopTrackingTouch(seekBar: IndicatorSeekBar?) {
                presenter.notifyUpdate()
            }
        }

        height.onSeekChangeListener = listener
        weight.onSeekChangeListener = listener
        age.onSeekChangeListener = listener

        submit.setOnClickListener {
            (activity as? MainActivity)?.backToHome()
        }
    }

    fun addListenerOnButton() {
        radio_sex.setOnCheckedChangeListener { _, _ ->
            presenter.notifyUpdate()
        }
    }

    private fun Sex.toRadioId() : Int = when (this) {
        Sex.Female -> {
            R.id.radio_female
        }
        else -> {
            R.id.radio_male
        }
    }

    private fun Int.toSex() : Sex = when (this) {
        R.id.radio_female -> {
            Sex.Female
        }
        else -> {
            Sex.Male
        }
    }

    override fun updatePerson(person: Person) {
        updateNorm(person.norm.format(2))

        radio_sex.check(person.sex.toRadioId())
        height_title.text = "Рост, см - ${person.height}"
        height.setProgress(person.height.toFloat())
        weight.setProgress(person.weight.toFloat())
        weight_title.text = "Вес, кг - ${person.weight}"
        age.setProgress(person.age.toFloat())
        age_title.text = "Возвраст - ${person.age}"

        setUpListeners()
    }

    override fun updateNorm(normText: String) {
        norm?.text = "$normText л."
    }

    override fun getNewPerson(): Person {

        return Person(radio_sex.checkedRadioButtonId.toSex(),
            height.progress,
            weight.progress,
            age.progress,
            .0,
            Date().format()
        )

    }

    override fun getLayoutId(): Int = R.layout.fragment_profile

    override fun injectDependencies() {
        DaggerProfileComponent.builder()
            .appComponent(App.component)
            .profileModule(ProfileModule())
            .build()
            .inject(this)
    }

    override fun onBackKeyPressed() {
    }

    override fun attachView() {
        presenter.attachView(this)
    }
}