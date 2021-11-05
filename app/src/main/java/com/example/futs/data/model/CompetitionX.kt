package com.example.futs.data.model

import com.squareup.moshi.Json

data class CompetitionX (
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String,
)