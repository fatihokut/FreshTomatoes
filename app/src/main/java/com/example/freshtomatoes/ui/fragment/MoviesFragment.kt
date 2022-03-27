package com.example.freshtomatoes.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.freshtomatoes.R
import com.example.freshtomatoes.ui.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment() {
    companion object {
        private const val TAG = "MoviesFragment"
    }

    private val model: MoviesViewModel by lazy { ViewModelProvider(this)[MoviesViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        model.getMovies()
        model.movies.observe(viewLifecycleOwner) {
            // Todo
        }

        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

}