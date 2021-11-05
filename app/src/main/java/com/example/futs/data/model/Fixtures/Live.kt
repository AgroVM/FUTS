package com.example.futs.data.model.Fixtures

import com.squareup.moshi.Json

data class Live(
    @field:Json(name = "1")
    val `1`: Any,
    @field:Json(name = "2")
    val `2`: Any,
    @field:Json(name = "x")
    val X: Any
)