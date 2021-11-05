package com.example.futs.presentation.fragments

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.futs.data.FootballAPIClient
import com.example.futs.data.cb.CountryRetrieved
import com.example.futs.data.model.Country

private const val TAG = "CompetitionViewModel"

class CountryViewModel() : ViewModel(), CountryRetrieved {

    private val _leagueViewModel = MutableLiveData<List<Country>>()
    val leagueLiveData = _leagueViewModel


    fun loadLeague() {
        FootballAPIClient.getListOfCountry(this)
    }

    override fun onDataFetchedSuccess(country: List<Country>) {
        Log.d(TAG, "onDataFetchedSuccess | ${country.size} new competitions")
        _leagueViewModel.postValue(country)
    }

    override fun onDataFetchedFailed() {
        Log.e(TAG, "Unable to retrieve new data")
        _leagueViewModel.postValue(emptyList())
    }
}