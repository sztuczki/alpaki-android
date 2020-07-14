package com.example.alpaki.core.utils

import android.app.Activity
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class ExampleInjectedClass @Inject constructor(
    private val activity: Activity
) {

    fun doSomething() = Unit
}