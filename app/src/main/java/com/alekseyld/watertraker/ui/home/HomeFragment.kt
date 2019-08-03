package com.alekseyld.watertraker.ui.home

import android.os.Bundle
import com.alekseyld.watertraker.App
import com.alekseyld.watertraker.R
import ru.nvtech.sedkp.base.BaseFragment

class HomeFragment : BaseFragment<HomePresenter, HomeContract.View>(), HomeContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }

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