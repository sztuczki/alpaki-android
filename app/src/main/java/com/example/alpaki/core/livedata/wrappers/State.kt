package com.example.alpaki.core.livedata.wrappers

sealed class State<T>(val data: T? = null) {

    var wasHandled = false
        protected set

    class Success<T>(data: T) : State<T>(data) {

        val unhandledData: T?
            get() = if (wasHandled) {
                null
            } else {
                data
            }.also { wasHandled = true }
    }

    class Error<T>(val error: Throwable) : State<T>() {

        val unhandledError: Throwable?
            get() = if (wasHandled) {
                null
            } else {
                error
            }.also { wasHandled = true }
    }

    class Loading<T> : State<T>()
}