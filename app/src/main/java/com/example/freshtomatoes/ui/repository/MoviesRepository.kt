package com.example.freshtomatoes.ui.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.freshtomatoes.api.MoviesService.Companion.instance
import com.example.freshtomatoes.api.model.ResponseWrapper
import com.example.freshtomatoes.ui.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepository @Inject constructor() {
    companion object {
        private const val TAG = "MoviesRepository"
    }

    val movies = MutableLiveData<ArrayList<Movie>>()

    fun getUpcomingMovies() {
        instance.getUpcomingMovies().enqueue(object :
            Callback<ResponseWrapper> {
            override fun onFailure(call: Call<ResponseWrapper>, t: Throwable) {
                Log.d(TAG, "Unsuccessful request: " + t.message)
            }

            override fun onResponse(
                call: Call<ResponseWrapper>,
                response: Response<ResponseWrapper>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    Log.d(TAG, "Success: " + response.raw().request().url().toString())
                    response.body()?.let { it ->
                        movies.postValue(buildResults(it))
                    }
                } else {
                    onFailure(
                        call,
                        Throwable("Unsuccessful request: " + response.code())
                    )
                }
            }
        })

    }

    private fun buildResults(wrapper: ResponseWrapper): ArrayList<Movie> {
//        Log.d(TAG, "Build results = " + wrapper.results)
        wrapper.let { response ->
            val resultsList = ArrayList<Movie>()
            response.results?.forEach {
                resultsList.add(
                    Movie(
                        it.title
                    )
                )
            }

            return resultsList
        }
    }

}