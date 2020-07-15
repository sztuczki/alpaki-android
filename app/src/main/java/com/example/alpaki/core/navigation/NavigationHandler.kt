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
            R.id.firstFragment -> navigationController.popBackStack(R.id.firstFragment, false)
            R.id.secondFragment -> navigationController.popBackStack(R.id.secondFragment, false)
            R.id.thirdFragment -> navigationController.popBackStack(R.id.thirdFragment, false)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val navigationController = requireNotNull(navigationController)
        return when (item.itemId) {
            R.id.firstFragment -> {
                navigationController.currentDestination?.id != R.id.firstFragment
            }
            R.id.secondFragment -> {
                navigationController.currentDestination?.id != R.id.secondFragment
            }
            R.id.thirdFragment -> {
                navigationController.currentDestination?.id != R.id.thirdFragment
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
