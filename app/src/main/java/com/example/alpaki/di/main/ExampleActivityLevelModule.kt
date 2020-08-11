package com.example.alpaki.di.main

import com.example.domain.repositories.TokenRepository
import com.example.domain.usecases.Login
import com.example.domain.usecases.Register
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ExampleActivityLevelModule {

    @Provides
    fun provideLoginUseCase(tokenRepository: TokenRepository): Login =
        Login(tokenRepository)

    @Provides
    fun provideRegisterUseCase(tokenRepository: TokenRepository): Register =
        Register(tokenRepository)
}
