package com.example.alpaki.presentation.main

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.alpaki.R
import com.example.alpaki.core.utils.ExampleInjectedClass
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var exampleInjectedClass: ExampleInjectedClass

    @Inject
    lateinit var injectedActionBar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        exampleInjectedClass.doSomething()
        injectedActionBar.height
    }
}