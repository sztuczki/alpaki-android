package com.example.alpaki.core.navigation

import android.view.MenuItem
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.alpaki.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class NavigationHandler :
    BottomNavigationView.OnNavigationItemReselectedListener,
    BottomNavigationView.OnNavigationItemSelectedListener {

    private var navigationController: NavController? = null
    private var viewBottomNavigation: BottomNavigationView? = null

    override fun onNavigationItemReselected(item: MenuItem) {
        val navigationController = requireNotNull(navigationController)
        when (item.itemId) {
            R.id.desktopFragment -> navigationController.popBackStack(R.id.desktopFragment, false)
            R.id.dreamsFragment -> navigationController.popBackStack(R.id.dreamsFragment, false)
            R.id.tasksFragment -> navigationController.popBackStack(R.id.tasksFragment, false)
            R.id.profileFragment -> navigationController.popBackStack(R.id.profileFragment, false)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val navigationController = requireNotNull(navigationController)
        return when (item.itemId) {
            R.id.desktopFragment -> {
                navigationController.currentDestination?.id != R.id.desktopFragment
            }
            R.id.dreamsFragment -> {
                navigationController.currentDestination?.id != R.id.dreamsFragment
            }
            R.id.tasksFragment -> {
                navigationController.currentDestination?.id != R.id.tasksFragment
            }
            R.id.profileFragment -> {
                navigationController.currentDestination?.id != R.id.profileFragment
            }
            else -> false
        }
    }

    fun initNavigation(owner: LifecycleOwner) {
        val activity = owner as FragmentActivity

        navigationController = activity.findNavController(R.id.fragmentNavHost)
        viewBottomNavigation = activity.bottomNavigationView

        requireNotNull(viewBottomNavigation).apply {
            setOnNavigationItemReselectedListener(this@NavigationHandler)
            setOnNavigationItemSelectedListener(this@NavigationHandler)
        }
        NavigationUI.setupWithNavController(
            requireNotNull(viewBottomNavigation),
            requireNotNull(navigationController)
        )
    }
}
