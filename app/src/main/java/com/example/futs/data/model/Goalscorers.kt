package com.example.futs.data.model

import com.squareup.moshi.Json

data class Goalscorers (
    @field:Json(name = "assists")
    val assists: String,
    @field:Json(name = "competition_id")
    val competition_id: String,
    @field:Json(name = "edition_id")
    val edition_id: String,
    @field:Json(name = "goals")
    val goals: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "played")
    val played: String,
    @field:Json(name = "player_id")
    val player_id: String,
    @field:Json(name = "season_id")
    val season_id: String,
    @field:Json(name = "team")
    val team: Team,
    @field:Json(name = "team_id")
    val team_id: String
)