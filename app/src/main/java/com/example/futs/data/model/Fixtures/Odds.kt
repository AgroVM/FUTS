package com.example.futs.data.model.Fixtures

import com.squareup.moshi.Json

data class Odds(
    @field:Json(name = "live")
    val live: Live,
    @field:Json(name = "pre")
    val pre: Pre
)