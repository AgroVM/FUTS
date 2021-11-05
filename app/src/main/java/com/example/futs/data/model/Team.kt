package com.example.futs.data.model

import com.squareup.moshi.Json

data class Team (
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "location")
    val location: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "stadium")
    val stadium: String
)