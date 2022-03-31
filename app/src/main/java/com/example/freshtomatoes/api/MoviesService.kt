package com.example.freshtomatoes.api

import com.example.freshtomatoes.BuildConfig
import com.example.freshtomatoes.api.model.ResponseWrapper
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface MoviesService {

    @GET("movie/upcoming?api_key=${BuildConfig.API_KEY}")
    fun getUpcomingMovies(@Query("page") pageNumber: Int): Call<ResponseWrapper>

    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BuildConfig.TMDB_BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }

        val instance: MoviesService by lazy { retrofit.create(MoviesService::class.java) }
    }
}