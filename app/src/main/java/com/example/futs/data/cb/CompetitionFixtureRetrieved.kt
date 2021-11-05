package com.example.futs.data.cb

import com.example.futs.data.model.Fixtures.Fixture


interface CompetitionFixtureRetrieved{

    fun onCompetitionFixtureFetchedSuccess(fixtures: List<Fixture>?)

    fun onCompetitionFixtureFetchedFailed()
}

