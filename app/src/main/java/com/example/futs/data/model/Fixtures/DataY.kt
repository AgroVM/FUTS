package com.example.futs.data.model.Fixtures

import com.squareup.moshi.Json

data class DataY(
    @field:Json(name = "data")
    val `data`: Data,
    @field:Json(name = "success")
    val success: Boolean
)