package com.example.freshtomatoes.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.freshtomatoes.databinding.FragmentMovieDetailsBinding
import com.example.freshtomatoes.ui.model.Movie

class MovieDetailsFragment : Fragment() {

    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: MovieDetailsFragmentArgs by navArgs()
    private lateinit var movie: Movie

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        movie = args.selectedMovie

        binding.apply {
            title.text = movie.title
            release.text = movie.releaseDate
            overview.text = movie.overview
            posterUrl = movie.posterPath
        }

        return view
    }

}