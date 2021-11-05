package com.example.futs.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.futs.EXTRA_COMPETITION_ID
import com.example.futs.EXTRA_COMPETITION_NAME
import com.example.futs.EXTRA_COUNTRY_ID
import com.example.futs.R
import com.example.futs.data.FootballAPIClient
import com.example.futs.data.cb.CompetitionRetrieved
import com.example.futs.data.model.Competition
import com.example.futs.presentation.adapters.CompetitionAdapter

private const val TAG = "CompetitionActivity"

class CompetitionActivity : AppCompatActivity(), CompetitionRetrieved {

    private val _competitionViewModel = MutableLiveData<List<Competition>>()
    val _competitionLiveData = _competitionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.competition_activity)

        setup()

    }

    private fun setup() {
        val countryId = intent.getStringExtra(EXTRA_COUNTRY_ID)

        if (countryId != null) {
            FootballAPIClient.getListOfCompetition(countryId,  this)
        }
        Log.d("setupfunction", "$countryId")

        findViewById<RecyclerView>(R.id.rv_competition).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = CompetitionAdapter(::openTableScreen)
        }

        _competitionLiveData.observe(this) {
            val adapter = findViewById<RecyclerView>(R.id.rv_competition).adapter as CompetitionAdapter
            adapter.submitList(it)
        }
    }

    override fun onCompetitionFetchedSuccess(competition: List<Competition>) {
        Log.d("competitionData", "${competition.size}")
        _competitionViewModel.postValue(competition)
    }

    override fun onCompetitionFetchedFailed() {
        Log.e(TAG, "Unable to retrieve competition name")
        _competitionViewModel.postValue(emptyList())
    }

    private fun openTableScreen(competition: Competition) {
        val intent = Intent(this, LeagueActivity::class.java)
        intent.putExtra(EXTRA_COMPETITION_NAME, competition.name)
        intent.putExtra(EXTRA_COMPETITION_ID, competition.id)
        Log.d("vasco", "${competition.id}")
        startActivity(intent)
    }

}