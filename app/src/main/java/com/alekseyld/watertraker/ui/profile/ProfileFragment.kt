package com.alekseyld.watertraker.ui.profile

import android.os.Bundle
import com.alekseyld.watertraker.App
import com.alekseyld.watertraker.R
import kotlinx.android.synthetic.main.fragment_profile.*
import ru.nvtech.sedkp.base.BaseFragment


class ProfileFragment : BaseFragment<ProfilePresenter, ProfileContract.View>(), ProfileContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addListenerOnButton()
    }

    fun addListenerOnButton() {
        radio_sex.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {

                R.id.radio_male -> {

                }

                R.id.radio_female -> {

                }
            }
        }
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
}