package com.example.freshtomatoes.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.navOptions
import androidx.recyclerview.widget.GridLayoutManager
import com.example.freshtomatoes.R
import com.example.freshtomatoes.databinding.FragmentMoviesBinding
import com.example.freshtomatoes.ui.adapter.CardAdapter
import com.example.freshtomatoes.ui.adapter.MovieClickListener
import com.example.freshtomatoes.ui.model.Movie
import com.example.freshtomatoes.ui.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment(), MovieClickListener {
    companion object {
        private const val TAG = "MoviesFragment"
    }

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    private val model: MoviesViewModel by lazy { ViewModelProvider(this)[MoviesViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        val view = binding.root

        val recyclerView = binding.recyclerView

        val movieAdapter = CardAdapter(this)
        recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = movieAdapter
        }

        model.getMovies()
        model.movies.observe(viewLifecycleOwner) {
            movieAdapter.submitList(it)
        }

        return view
    }

    override fun onClick(movie: Movie) {
        // Todo: Animation
//        val options = navOptions {
//            anim {
//                enter = R.anim.
//                exit = R.anim.slide_out_left
//                popEnter = R.anim.slide_in_left
//                popExit = R.anim.slide_out_right
//            }
//        }
        val action = MoviesFragmentDirections.moviesToDetails(movie)
        Navigation.findNavController(binding.root).navigate(action)
    }

}