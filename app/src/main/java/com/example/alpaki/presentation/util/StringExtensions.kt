package com.example.alpaki.presentation.util

import android.util.Patterns

fun String?.isEmailValid() = this?.let { Patterns.EMAIL_ADDRESS.matcher(this).matches() } ?: false

fun String?.isPhoneValid() = this?.let { Patterns.PHONE.matcher(this).matches() } ?: false
