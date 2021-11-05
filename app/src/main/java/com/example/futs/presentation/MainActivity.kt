package com.example.futs.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.futs.R
import com.example.futs.presentation.fragments.CalendarFragment
import com.example.futs.presentation.fragments.CountryFragment
import com.example.futs.presentation.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val homeFragment by lazy { HomeFragment() }
    private val countryFragment by lazy { CountryFragment() }
    private val calendarFragment by lazy { CalendarFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.calendar -> {
                    loadFragment(calendarFragment)
                    true
                }

                R.id.home -> {
                    loadFragment(homeFragment)
                    true
                }

                R.id.country -> {
                    loadFragment(countryFragment)
                    true
                }

                else -> false
            }
        }
        bottomNavigationView.selectedItemId = R.id.home
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.navigationContainer, fragment)
            .commit()
    }
}