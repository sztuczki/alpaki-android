package com.example.alpaki.di.main

import android.app.Activity
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.alpaki.core.navigation.NavigationHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ExampleActivityLevelModule {

    @Provides
    fun provideActionBar(activity: Activity): ActionBar {
        return (activity as AppCompatActivity).supportActionBar ?: throw IllegalStateException()
    }

    @Provides
    fun provideNavigationHandler()= NavigationHandler()
}
