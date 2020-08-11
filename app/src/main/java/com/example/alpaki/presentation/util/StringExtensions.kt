package com.example.alpaki.presentation.util

import android.util.Patterns

private const val MINIMUM_LENGTH = 8

fun String?.isEmailValid() = this?.let { Patterns.EMAIL_ADDRESS.matcher(this).matches() } ?: false

fun String?.isPhoneValid() = this?.let { Patterns.PHONE.matcher(this).matches() } ?: false

fun String?.isPasswordValid() = this?.let { length >= MINIMUM_LENGTH } ?: false
