package com.example.futs.data.model

import com.squareup.moshi.Json

data class GoalsData (
    @field:Json(name = "data")
    val data: DataX,
    @field:Json(name = "success")
    val success: Boolean
)