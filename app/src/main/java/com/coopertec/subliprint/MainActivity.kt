package com.coopertec.subliprint

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.coopertec.subliprint.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navHost()
    }


    private fun navHost() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_activity_fragment) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView = binding.buttonNavMain
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.printHomeFragment -> {
                    binding.topAppBar.setTitle(getString(R.string.print_home_name_menu))
                }
                R.id.exploreFragment -> {
                    binding.topAppBar.setTitle(getString(R.string.descubrir_name_menu))
                }
                R.id.favoritesFragment -> {
                    binding.topAppBar.setTitle(getString(R.string.favoritos_name_menu))
                }
            }
        }
    }
}