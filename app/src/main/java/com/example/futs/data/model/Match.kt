package com.example.futs.data.model

import com.squareup.moshi.Json

data class Match (
    @field:Json(name = "added")
    val added: String,
    @field:Json(name = "away_id")
    val away_id: Int,
    @field:Json(name = "away_name")
    val away_name: String,
    @field:Json(name = "competition_id")
    val competition_id: Int,
    @field:Json(name = "competition_name")
    val competition_name: String,
    @field:Json(name = "et_score")
    val et_score: String,
    @field:Json(name = "events")
    val events: Any,
    @field:Json(name = "fixture_id")
    val fixture_id: Int,
    @field:Json(name = "ft_score")
    val ft_score: String,
    @field:Json(name = "home_id")
    val home_id: Int,
    @field:Json(name = "home_name")
    val home_name: String,
    @field:Json(name = "ht_score")
    val ht_score: String,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "last_changed")
    val last_changed: String,
    @field:Json(name = "league_id")
    val league_id: Int,
    @field:Json(name = "league_name")
    val league_name: String,
    @field:Json(name = "location")
    val location: String,
    @field:Json(name = "scheduled")
    val scheduled: String,
    @field:Json(name = "score")
    val score: String,
    @field:Json(name = "status")
    val status: String,
    @field:Json(name = "time")
    val time: String
)