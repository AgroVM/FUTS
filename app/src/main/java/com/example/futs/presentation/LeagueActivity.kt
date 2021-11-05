package com.example.futs.presentation


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.footballapi.presentation.leagueFragments.TableFragment
import com.example.futs.R
import com.example.futs.presentation.leagueFragments.CompetitionFixturesFragment
import com.example.futs.presentation.leagueFragments.GoalsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class LeagueActivity: AppCompatActivity(){



    private val competitionFixturesFragment by lazy { CompetitionFixturesFragment() }
    private val tableFragment by lazy { TableFragment() }
    private val goalsFragment by lazy { GoalsFragment() }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.fixtures -> {
                    loadFragment(competitionFixturesFragment)
                    true
                }

                R.id.table -> {
                    loadFragment(tableFragment)
                    true
                }

                R.id.goals -> {
                    loadFragment(goalsFragment)
                    true
                }

                else -> false
            }
        }
        bottomNavigationView.selectedItemId = R.id.table
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.navigationContainer, fragment)
            .commit()
    }


}