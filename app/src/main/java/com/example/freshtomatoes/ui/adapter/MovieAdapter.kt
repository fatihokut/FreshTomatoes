package com.example.freshtomatoes.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.freshtomatoes.databinding.MovieCardBinding
import com.example.freshtomatoes.ui.model.Movie


class CardAdapter(
    private val clickListener: MovieClickListener
) : ListAdapter<Movie, MovieViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = MovieCardBinding.inflate(from, parent, false)
        return MovieViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(getItem(position))
    }

}

object DiffCallback : DiffUtil.ItemCallback<Movie>() {

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie) =
        (oldItem.title == newItem.title) &&
                (oldItem.releaseDate == newItem.releaseDate) &&
                (oldItem.overview == newItem.overview)
}