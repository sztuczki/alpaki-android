package com.example.alpaki.core.navigation

import android.view.MenuItem
import androidx.activity.addCallback
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.alpaki.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@ActivityScoped
class NavigationHandler @Inject constructor() :
    BottomNavigationView.OnNavigationItemReselectedListener,
    BottomNavigationView.OnNavigationItemSelectedListener {

    private var activity: FragmentActivity? = null
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

    fun init(owner: LifecycleOwner) {
        val activity = owner as FragmentActivity
        this.activity = activity

        activity.onBackPressedDispatcher.addCallback(activity) {
            handleBackPress()
        }

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

    private fun handleBackPress() = with(requireNotNull(navigationController)) {
        val activity = requireNotNull(activity)
        when (currentDestination?.id) {
            R.id.desktopFragment -> activity.finish()
            R.id.dreamsFragment -> popBackStack(R.id.desktopFragment, false)
            R.id.tasksFragment -> popBackStack(R.id.desktopFragment, false)
            R.id.profileFragment -> popBackStack(R.id.desktopFragment, false)
            R.id.myProfileFragment -> popBackStack(R.id.desktopFragment, false)
            R.id.registerFragment -> popBackStack(R.id.profileFragment, false)
            else -> if (popBackStack().not()) activity.finish()
        }
        Unit
    }
}
