package com.example.alpaki.di

import com.example.alpaki.di.core.RetrofitModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module(
    includes = [
        RetrofitModule::class]
)
@InstallIn(ApplicationComponent::class)
object ApplicationModule