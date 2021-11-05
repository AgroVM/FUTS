package com.example.futs.data.model

import com.squareup.moshi.Json

data class League (
    @field:Json(name = "country_id")
    val country_id: String,
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "name")
    val name: String
)