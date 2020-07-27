package com.example.alpaki.presentation.util

import android.content.res.TypedArray

inline fun TypedArray.use(block: TypedArray.() -> Unit) {
    try {
        block()
    } finally {
        this.recycle()
    }
}
