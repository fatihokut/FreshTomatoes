package com.example.freshtomatoes.api.model

import com.squareup.moshi.Json

data class ResponseWrapper(
    @Json(name = "results")
    val results: List<Result>?
)
