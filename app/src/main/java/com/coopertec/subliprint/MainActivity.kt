package com.coopertec.subliprint

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.coopertec.subliprint.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolMainBar)

        navHost()
    }

    private fun navHost() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_activity_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Esto se usa para configurar la barra de navegación inferior si tienes una
        val bottomNavigationView = binding.buttonNavMain

//        // Asegúrate de que el conjunto esté vacío, así no hay manejo de "back arrow"
        appBarConfiguration = AppBarConfiguration(setOf())
//
//        // Vincula el controlador de navegación al AppBar
//        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        // Desactiva explícitamente el botón de retroceso
//        supportActionBar?.setDisplayHomeAsUpEnabled(false)
//
        // Configura la barra de navegación inferior si aplica
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }

}