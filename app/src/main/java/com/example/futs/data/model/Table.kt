package com.example.futs.data.model

import com.squareup.moshi.Json

data class Table (
    @field:Json(name = "league_id")
    val league_id: String,
    @field:Json(name = "season_id")
    val season_id: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "rank")
    val rank: String,
    @field:Json(name = "points")
    val points: String,
    @field:Json(name = "matches")
    val matches: String,
    @field:Json(name = "goal_diff")
    val goal_diff: String,
    @field:Json(name = "goals_scored")
    val goals_scored: String,
    @field:Json(name = "goals_conceded")
    val goals_conceded: String,
    @field:Json(name = "lost")
    val lost: String,
    @field:Json(name = "drawn")
    val drawn: String,
    @field:Json(name = "won")
    val won: String,
    @field:Json(name = "team_id")
    val team_id: String,
    @field:Json(name = "competition_id")
    val competition_id: String
)