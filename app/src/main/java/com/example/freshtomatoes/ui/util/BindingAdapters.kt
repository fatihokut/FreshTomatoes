package com.example.freshtomatoes.ui.util

import android.R
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.freshtomatoes.BuildConfig

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("moviePoster")
    fun loadImage(view: ImageView, posterUrl: String?) {
        if (!posterUrl.isNullOrEmpty()) {
            Glide.with(view.context)
                .load(BuildConfig.IMG_BASE_URL + posterUrl)
                .placeholder(R.drawable.stat_sys_download)
                .into(view)
        }
    }
}