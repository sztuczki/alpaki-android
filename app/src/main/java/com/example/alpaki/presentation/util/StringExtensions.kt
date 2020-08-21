package com.example.alpaki.presentation.util

import android.util.Patterns
import com.example.data.api.CODE_LENGTH
import com.example.data.api.PASSWORD_MINIMUM_LENGTH

fun String?.isEmailValid() = this?.let { Patterns.EMAIL_ADDRESS.matcher(this).matches() } ?: false

fun String?.isPhoneValid() = this?.let { Patterns.PHONE.matcher(this).matches() } ?: false

fun String?.isPasswordValid() = this?.let { length >= PASSWORD_MINIMUM_LENGTH } ?: false

fun String?.isCodeValid() = this?.let { length == CODE_LENGTH} ?: false
