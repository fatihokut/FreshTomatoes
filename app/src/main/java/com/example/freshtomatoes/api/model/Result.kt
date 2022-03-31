package com.example.freshtomatoes.api.model

import com.squareup.moshi.Json

data class Result(
    @Json(name = "title")
    val title: String,
    @Json(name = "poster_path")
    val poster_path: String?,
    @Json(name = "release_date")
    val release_date: String,
    @Json(name = "overview")
    val overview: String

)
