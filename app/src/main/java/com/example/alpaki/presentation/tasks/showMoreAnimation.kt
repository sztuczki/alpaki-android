package com.example.alpaki.presentation.tasks

import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageButton

fun ImageButton.rotateOnClick() {
    val deg = if (this.rotation == 180f) 0f else 180f
    this.animate().rotation(deg).interpolator = AccelerateDecelerateInterpolator()
}