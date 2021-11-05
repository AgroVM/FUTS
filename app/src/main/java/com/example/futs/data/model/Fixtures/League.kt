package com.example.futs.data.model.Fixtures

import com.squareup.moshi.Json

data class League(
    @field:Json(name = "country_id")
    val country_id: Any,
    @field:Json(name = "id")
    val id: Any,
    @field:Json(name = "name")
    val name: Any
)