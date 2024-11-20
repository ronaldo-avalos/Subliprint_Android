package com.coopertec.subliprint.presentation.printHome.toolsBox.guidesSublimation

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.coopertec.subliprint.R
import com.coopertec.subliprint.databinding.ActivityGuiesBinding

class GuidesActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityGuiesBinding
    private var shouldFinishActivity = false
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        navController = findNavController(R.id.nav_host_fragment_content_guies)
        appBarConfiguration = AppBarConfiguration(setOf())
        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            shouldFinishActivity = destination.id == R.id.guidesFragment
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
        if (currentDestinationId == R.id.guidesFragment) {
            finish()
        } else {
            navController.popBackStack()
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_guies)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}