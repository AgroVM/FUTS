package com.example.futs.data.model

import com.squareup.moshi.Json

data class Competition (
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "country")
    val country: List<Country>,
    @field:Json(name = "federation")
    val federation: Federation
)