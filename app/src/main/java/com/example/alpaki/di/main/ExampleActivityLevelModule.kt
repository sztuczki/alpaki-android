package com.example.alpaki.di.main

import com.example.data.repository.TokenRepository
import com.example.data.usecases.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ExampleActivityLevelModule {

    @Provides
    fun provideLoginUseCase(tokenRepository: TokenRepository): LoginUseCase =
        LoginUseCase(tokenRepository)
}
