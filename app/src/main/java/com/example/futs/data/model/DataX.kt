package com.example.futs.data.model

import com.squareup.moshi.Json

data class DataX (
    @field:Json(name = "competition")
    val competition: CompetitionX,
    @field:Json(name = "goalscorers")
    val goalscorers: List<Goalscorers>,
    @field:Json(name = "match")
    val match: List<Match>,
    @field:Json(name = "fixture")
    val fixtures: List<Fixture>,
    @field:Json(name = "next_page")
    val next_page: String,
    @field:Json(name = "prev_page")
    val prev_page: Boolean
)