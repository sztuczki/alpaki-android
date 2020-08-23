package com.example.alpaki.presentation.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.alpaki.R

@BindingAdapter("urlImage")
fun ImageView.urlCircleImage(url: String) {
    Glide.with(this).load(url).circleCrop().placeholder(R.drawable.ic_launcher_background)
        .into(this)
}