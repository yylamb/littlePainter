package com.example.littlepainter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.littlepainter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)

        binding.bottomNavigationView.setOnItemSelectedListener {MenuItem ->
            navController.popBackStack()
            when(MenuItem.itemId){
                R.id.guideFragment -> navController.navigate(R.id.guideFragment)
                R.id.welcomeFragment -> navController.navigate(R.id.welcomeFragment)
                R.id.homeFragment -> navController.navigate(R.id.homeFragment)
                R.id.drawFragment -> navController.navigate(R.id.drawFragment)
            }
            true
        }
    }
}