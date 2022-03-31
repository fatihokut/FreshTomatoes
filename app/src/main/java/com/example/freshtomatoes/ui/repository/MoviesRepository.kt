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
    val batch = ArrayList<Movie>()

    fun getUpcomingMovies(page: Int) {
        instance.getUpcomingMovies(page).enqueue(object :
            Callback<ResponseWrapper> {
            override fun onFailure(call: Call<ResponseWrapper>, t: Throwable) {
                Log.d(TAG, "Unsuccessful request: " + t.message)
            }

            override fun onResponse(
                call: Call<ResponseWrapper>,
                response: Response<ResponseWrapper>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    response.body()?.let { it ->
                        batch.addAll(buildResults(it))
                        movies.postValue(batch)
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
        wrapper.let { response ->
            val resultsList = ArrayList<Movie>()
            response.results?.forEach {
                resultsList.add(
                    Movie(
                        it.title,
                        it.poster_path,
                        it.release_date,
                        it.overview
                    )
                )
            }

            return resultsList
        }
    }

}