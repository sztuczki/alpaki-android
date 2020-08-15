package com.example.alpaki.di

import com.example.alpaki.di.core.RetrofitModule
import com.example.data.di.DatabaseModule
import com.example.data.di.DataModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module(
    includes = [
        DataModule::class,
        DatabaseModule::class,
        RetrofitModule::class]
)
@InstallIn(ApplicationComponent::class)
object ApplicationModule