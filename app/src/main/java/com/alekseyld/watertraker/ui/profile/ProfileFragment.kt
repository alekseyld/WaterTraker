package com.alekseyld.watertraker.ui.profile

import com.alekseyld.watertraker.App
import com.alekseyld.watertraker.R
import ru.nvtech.sedkp.base.BaseFragment

class ProfileFragment : BaseFragment<ProfilePresenter, ProfileContract.View>(), ProfileContract.View {

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