package com.example.freshtomatoes.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val title: String,
    val posterPath: String?,
    val releaseDate: String,
    val overview: String
) : Parcelable

