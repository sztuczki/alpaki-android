package com.example.alpaki.presentation.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.domain.models.UserDetails

@BindingAdapter("bindNameSurname")
fun TextView.bindNameSurname(userDetails: UserDetails?) {
    text = StringBuilder()
        .append("${userDetails?.firstName ?: ""} ${userDetails?.lastName ?: ""}")
}