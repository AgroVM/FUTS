package com.example.futs.data.model.Fixtures

import com.squareup.moshi.Json

data class Fixture(
    @field:Json(name = "away_id")
    val away_id: Int,
    @field:Json(name = "away_name")
    val away_name: String,
    @field:Json(name = "away_translations")
    val away_translations: Any,
    @field:Json(name = "competition")
    val competition: Competition,
    @field:Json(name = "competition_id")
    val competition_id: Int,
    @field:Json(name = "date")
    val date: String,
    @field:Json(name = "h2h")
    val h2h: String,
    @field:Json(name = "home_id")
    val home_id: Int,
    @field:Json(name = "home_name")
    val home_name: String,
    @field:Json(name = "home_translations")
    val home_translations: Any,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "league")
    val league: League,
    @field:Json(name = "league_id")
    val league_id: Int,
    @field:Json(name = "location")
    val location: String,
    @field:Json(name = "odds")
    val odds: Odds,
    @field:Json(name = "round")
    val round: String,
    @field:Json(name = "time")
    val time: String
)