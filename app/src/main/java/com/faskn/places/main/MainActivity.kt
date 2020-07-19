package com.faskn.places.main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.faskn.core.base.BaseActivity
import com.faskn.core.utils.extensions.hide
import com.faskn.core.utils.extensions.show
import com.faskn.places.R
import com.faskn.places.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(MainViewModel::class.java) {

    lateinit var navController: NavController
    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun initViewModel(viewModel: MainViewModel) {
        binding.viewModel = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController(R.id.container_fragment)
        setupNavigation()
    }

    private fun setupNavigation() {
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.splashFragment -> binding.toolbar.hide()
                R.id.dashboardFragment -> {
                    binding.toolbar.show()
                    setVisibilityOfBackButton(false)
                }
                else -> {
                    binding.toolbar.show()
                    setVisibilityOfBackButton(true)
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun setVisibilityOfBackButton(isVisible: Boolean) {
        when (isVisible) {
            true -> {
                supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_leftarrow)
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                supportActionBar?.setHomeButtonEnabled(true)
            }
            false -> {
                supportActionBar?.setHomeAsUpIndicator(R.color.transparent)
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                supportActionBar?.setHomeButtonEnabled(false)
            }
        }
    }
}
