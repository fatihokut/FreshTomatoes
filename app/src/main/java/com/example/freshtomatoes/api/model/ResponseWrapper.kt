package com.example.freshtomatoes.api.model

import com.squareup.moshi.Json

data class ResponseWrapper(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val results: List<Result>?,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)
