package com.example.alpaki.presentation.main

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.alpaki.R
import com.example.alpaki.core.navigation.NavigationHandler
import com.example.alpaki.core.utils.ExampleInjectedClass
import com.example.domain.usecases.ExampleUseCase
import com.example.domain.usecases.base.None
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var exampleInjectedClass: ExampleInjectedClass

    @Inject
    lateinit var injectedActionBar: ActionBar

    @Inject
    lateinit var navigationHandler: NavigationHandler

    @Inject
    lateinit var exampleUseCase: ExampleUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigationHandler.initNavigation(this)

        exampleUseCase(lifecycleScope, None, { result ->
            handleResult(result)
        }, { error ->
            handleError(error)
        })

//        alternatively
        exampleUseCase(lifecycleScope, None, ::handleResult, ::handleError)
    }

    private fun handleResult(result: String) = Unit

    private fun handleError(error: Throwable) = Unit
}