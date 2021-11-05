package com.example.futs.data.model

import com.squareup.moshi.Json

data class Country(
    @field:Json(name = "federation")
    val federation: Federation,
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "is_real")
    val is_real: String,
    @field:Json(name = "leagues")
    val leagues: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "national_team")
    val national_team: Any,
    @field:Json(name = "scores")
    val scores: String
)