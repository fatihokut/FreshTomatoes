package com.example.freshtomatoes.api.model

import com.squareup.moshi.Json

data class Result(
    @Json(name = "title")
    val title: String
)
