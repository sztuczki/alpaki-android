package com.example.alpaki.presentation.util

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.google.android.material.textfield.TextInputEditText


@BindingAdapter("setLiveData")
fun setLiveData(view: TextInputEditText, email: MutableLiveData<String>) {
    view.text?.let {
        email.value = it.toString()
    }
}

