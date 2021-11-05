package com.example.futs.data.cb

import com.example.futs.data.model.Country


interface CountryRetrieved {
    fun onDataFetchedSuccess(country: List<Country>)

    fun onDataFetchedFailed()
}