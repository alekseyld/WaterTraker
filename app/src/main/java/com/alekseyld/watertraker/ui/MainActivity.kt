package com.alekseyld.watertraker.ui

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.alekseyld.watertraker.R
import com.alekseyld.watertraker.format
import com.alekseyld.watertraker.ui.home.HomeFragment
import com.alekseyld.watertraker.ui.profile.ProfileFragment
import com.alekseyld.watertraker.ui.statistics.StatisticsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.nav_header_main.*
import ru.nvtech.sedkp.base.BaseFragment
import java.util.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        if (supportFragmentManager.findFragmentById(R.id.fragment_container) == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).addToBackStack(null).commit()
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        }
        if (supportFragmentManager.backStackEntryCount > 0) {
            val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

            (fragment as? BaseFragment<*, *>)?.onBackKeyPressed()
        }
        else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        //menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                replaceFragmentToContainer(HomeFragment())
            }
            R.id.nav_statistics -> {
                replaceFragmentToContainer(StatisticsFragment())
            }
            R.id.nav_profile -> {
                replaceFragmentToContainer(ProfileFragment())
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun fillNorm(norm: String) {
        header_date.text = Date().format()
        header_norm.text = norm
    }

    fun backToHome() {
        nav_view.setCheckedItem(R.id.nav_home)
        replaceFragmentToContainer(HomeFragment())
    }

    fun toProfile() {
        nav_view.setCheckedItem(R.id.nav_profile)
        replaceFragmentToContainer(ProfileFragment())
    }

    fun replaceFragmentToContainer(fragment: Fragment, checkSubContainer: Boolean = false, subContainerID: Int = -1) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment, "container").addToBackStack(null).commit()
    }
}
