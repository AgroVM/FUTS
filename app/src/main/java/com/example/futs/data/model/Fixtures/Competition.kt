package com.example.futs.data.model.Fixtures

import com.squareup.moshi.Json

data class Competition(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String
)