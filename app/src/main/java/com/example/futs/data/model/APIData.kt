package com.example.futs.data.model

import com.squareup.moshi.Json

data class APIData (
    @field:Json(name = "data")
    val data: Data,
)