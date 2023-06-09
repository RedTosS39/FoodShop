package com.example.foodshop

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.foodshop.databinding.ActivityMainBinding
import com.example.foodshop.ui.main.DishesFragment
import com.example.foodshop.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))

        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance()).commitNow()
        }
        setupMenu()
    }

    private fun setupMenu() {

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, MainFragment.newInstance()).commit()
                }

                R.id.menu_search -> {
                    Log.d("AAAA", "menu_search: ")
                }

                R.id.menu_bag -> {
                    Log.d("AAAA", "menu_bag: ")
                }
                R.id.menu_profile -> {
                    Log.d("AAAA", "menu_profile: ")
                }
            }
            true
        }
    }
}