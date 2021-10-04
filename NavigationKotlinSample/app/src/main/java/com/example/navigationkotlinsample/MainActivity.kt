package com.example.navigationkotlinsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigationkotlinsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        initNavController()
        observeDestination()
    }

    private fun observeDestination() {
        navController.addOnDestinationChangedListener { n, destination, _ ->
            updateContent(destination.id)
        }
    }

    private fun initNavController() {
        val host: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = host.navController
        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications,
            ),
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        this.setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.inflateMenu(R.menu.bottom_nav_menu)
        binding.navView.setupWithNavController(navController)
    }

    private fun updateContent(destinationId: Int) {
        when (destinationId) {
            R.id.splashFragment, R.id.loginFragment -> {
                supportActionBar?.hide()
                binding.navView.isVisible = false
            }
            else -> {
                supportActionBar?.show()
                binding.navView.isVisible = true
            }
        }
    }
}