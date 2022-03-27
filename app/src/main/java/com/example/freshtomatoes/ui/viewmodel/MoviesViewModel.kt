package com.example.freshtomatoes.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freshtomatoes.ui.model.Movie
import com.example.freshtomatoes.ui.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject internal constructor(
    private val repository: MoviesRepository
) : ViewModel() {

    private val _movies: MutableLiveData<ArrayList<Movie>> = repository.movies
    var movies: LiveData<ArrayList<Movie>> = _movies

    fun getMovies() {
        viewModelScope.launch {
            repository.getUpcomingMovies()
        }
    }

}