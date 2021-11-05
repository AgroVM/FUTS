package com.example.futs.data

import com.example.futs.data.model.APIData
import com.example.futs.data.model.DataX
import com.example.futs.data.model.Fixtures.DataY
import com.example.futs.data.model.GoalsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballAPI {
    @GET(COUNTRIES)
    fun getCountryList(@Query("key") key: String, @Query("secret") secret: String): Call<APIData>

    @GET(COMPETITIONS)
    fun getCompetitionList(@Query("key") key: String, @Query("secret") secret: String, @Query(COUNTRY_ID) Id: String) : Call<APIData>

    @GET(COMPETITIONS_TABLE)
    fun getTableList(@Query("key") key: String, @Query("secret") secret: String, @Query(COMPETITION_ID) Id: String) : Call<APIData>

    @GET(GOALSCORERS)
    fun getGoalscorersList(@Query("key") key: String, @Query("secret") secret: String, @Query(COMPETITION_ID) Id: String) : Call<GoalsData>

    @GET(FIXTURES)
    fun getCompetitionFixturesList(@Query("key") key: String, @Query("secret") secret: String, @Query(COMPETITION_ID) Id: String) : Call<GoalsData>

    @GET(FIXTURES)
    fun getCalendarList(@Query("key") key: String, @Query("secret") secret: String, @Query(CALENDAR_DATE) date: String) : Call<DataY>
}