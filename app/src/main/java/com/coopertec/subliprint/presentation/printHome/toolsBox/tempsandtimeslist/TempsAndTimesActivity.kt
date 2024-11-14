package com.coopertec.subliprint.presentation.printHome.toolsBox.tempsandtimeslist

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.coopertec.subliprint.R
import com.coopertec.subliprint.databinding.ActivityTempsAndTimesBinding

class TempsAndTimesActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityTempsAndTimesBinding
    private lateinit var navController: NavController
    private var shouldFinishActivity = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTempsAndTimesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        navController = findNavController(R.id.nav_host_fragment_content_temps_and_times)

        // Aquí pasamos un conjunto vacío a AppBarConfiguration para que muestre el botón de retroceso siempre
        appBarConfiguration = AppBarConfiguration(setOf())
        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            shouldFinishActivity = destination.id == R.id.fragmentTempsTimesList2
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            handleNavigationBack()
        }
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }
    }

    private fun handleNavigationBack() {
        val currentDestinationId = navController.currentDestination?.id
        if (currentDestinationId == R.id.fragmentTempsTimesList2) {
            finish()
        } else {
            navController.popBackStack()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_temps_and_times)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}