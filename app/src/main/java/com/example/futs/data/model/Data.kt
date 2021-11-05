package com.example.futs.data.model

import com.squareup.moshi.Json

data class Data (
    @field:Json(name = "country")
    val country: List<Country>,
    @field:Json(name = "competition")
    val competition: List<Competition>,
    @field:Json(name = "table")
    val table: List<Table>,
)