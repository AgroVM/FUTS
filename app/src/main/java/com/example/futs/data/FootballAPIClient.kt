package com.example.futs.data

import android.util.Log
import com.example.futs.data.model.APIData
import com.example.futs.data.model.GoalsData
import com.example.futs.data.cb.*
import com.example.futs.data.model.DataX
import com.example.futs.data.model.Fixtures.DataY
import com.example.futs.presentation.fragments.CalendarFragment
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.moshi.MoshiConverterFactory

private const val TAG = "FootballAPIClient"

object FootballAPIClient {
    private val apiFootball by lazy {
        setup()
    }

    private fun setup() : FootballAPI {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit.create()
    }

    fun getListOfCountry(listener: CountryRetrieved?= null)  {
        apiFootball.getCountryList(API_KEY, API_SECRET).enqueue(object : Callback<APIData> {
            override fun onResponse(call: Call<APIData>, response: Response<APIData>) {
                if (!response.isSuccessful) {
                    Log.e("getCountries", "code: " + response.code())
                    return
                }
                listener?.onDataFetchedSuccess(response.body()!!.data.country)
            }

            override fun onFailure(call: Call<APIData>, t: Throwable) {
                Log.e("getCountries", "onFailure ${t.message}")
                listener?.onDataFetchedFailed()
            }
        })
    }

    fun getListOfCompetition(Id: String,  listener: CompetitionRetrieved) {
        apiFootball.getCompetitionList(API_KEY, API_SECRET, Id).enqueue(object : Callback<APIData> {
            override fun onResponse(call: Call<APIData>, response: Response<APIData>) {
                if (!response.isSuccessful) {
                    Log.e("getLeagues", "code: " + response.code())
                    Log.e("getLeagues", "$Id")
                    return
                }
                listener.onCompetitionFetchedSuccess(response.body()!!.data.competition)
            }

            override fun onFailure(call: Call<APIData>, t: Throwable) {
                Log.e("getLeagues", "Unable to get country name. Error: ${t.message}")
                Log.e("getLeagues", "$Id")
            }
        })
    }

    fun getCompetitionTable(Id :String, listener: TableRetrieved) {
        apiFootball.getTableList(API_KEY, API_SECRET, Id).enqueue(object : Callback<APIData> {
            override fun onResponse(call: Call<APIData>, response: Response<APIData>) {
                if(!response.isSuccessful) {
                    Log.e("getTable", "code: " + response.code())
                    Log.e("getTable", "$Id")
                    return
                }
                listener.onTableFetchedSuccess(response.body()!!.data.table)
            }

            override fun onFailure(call: Call<APIData>, t: Throwable) {
                Log.e("getTable", "Unable to get competition_Id. Error: ${t.message}")
                Log.e("getTable", "$Id")
            }
        })
    }

    fun getGoalscorersTable(Id: String, listener: GoalscorerRetrieved) {
        apiFootball.getGoalscorersList(API_KEY, API_SECRET, Id).enqueue(object : Callback<GoalsData> {
            override fun onResponse(call: Call<GoalsData>, response: Response<GoalsData>) {
                if(!response.isSuccessful) {
                    Log.e("getGoalScorer", "code: " + response.code())
                    Log.e("getGoalscorer", "$Id")
                    return
                }
                listener.onGoalScorerFetchedSuccess(response.body()!!.data.goalscorers)
                Log.d("segundo", "${listener.onGoalScorerFetchedSuccess(response.body()!!.data.goalscorers)}")
            }

            override fun onFailure(call: Call<GoalsData>, t: Throwable) {
                Log.e("getGoalscorer", "Unable to get competition. Error: ${t.message}")
            }

        })
    }

    fun getListOfCalendar(date: String, listener: CompetitionFixtureRetrieved) {
        apiFootball.getCalendarList(API_KEY, API_SECRET, date).enqueue(object: Callback<DataY> {
            override fun onResponse(call: Call<DataY>, response: Response<DataY>) {
                if (!response.isSuccessful) {
                    Log.e("getCalendar", "code: " + response.code())
                    return
                }
                listener.onCompetitionFixtureFetchedSuccess(response.body()?.data?.fixtures)
            }

            override fun onFailure(call: Call<DataY>, t: Throwable) {
                Log.e("getCalendar", "Unable to get fixture. Error: ${t.message}")
            }

        })
    }
}