package com.example.futs.data.model

import com.squareup.moshi.Json

data class Federation (
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "name")
    val name: String,
)