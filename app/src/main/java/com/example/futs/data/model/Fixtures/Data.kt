package com.example.futs.data.model.Fixtures

import com.squareup.moshi.Json

data class Data(
    @field:Json(name = "fixtures")
    val fixtures: List<Fixture>,
    @field:Json(name = "next_page")
    val next_page: String,
    @field:Json(name = "prev_page")
    val prev_page: Boolean
)