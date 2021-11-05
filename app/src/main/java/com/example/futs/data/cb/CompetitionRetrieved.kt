package com.example.futs.data.cb

import com.example.futs.data.model.Competition


interface CompetitionRetrieved{
    fun onCompetitionFetchedSuccess(competition: List<Competition>)

    fun onCompetitionFetchedFailed()
}