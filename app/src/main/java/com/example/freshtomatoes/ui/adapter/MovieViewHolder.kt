package com.example.freshtomatoes.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.freshtomatoes.databinding.MovieCardBinding
import com.example.freshtomatoes.ui.model.Movie


class MovieViewHolder(
    private val movieCardBinding: MovieCardBinding,
    private val clickListener: MovieClickListener
) : RecyclerView.ViewHolder(movieCardBinding.root) {
    fun bindMovie(movie: Movie) {
        movieCardBinding.apply {
            title.text = movie.title
            release.text = movie.releaseDate
            posterUrl = movie.posterPath

            cardView.setOnClickListener {
                clickListener.onClick(movie)
            }
        }

    }

}