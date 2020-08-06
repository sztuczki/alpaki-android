package com.example.alpaki.di.main

import com.example.data.TokenRepositoryImpl
import com.example.data.repository.TokenRepository
import com.example.data.usecases.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object ExampleActivityLevelModule {

    @Provides
    @Singleton
    fun provideTokenRepository(tokenRepository: TokenRepositoryImpl): TokenRepository =
        tokenRepository

    /*@Provides
    @Singleton
    fun provideLoginUseCase(tokenRepository: TokenRepository): LoginUseCase =
        LoginUseCase(tokenRepository)*/
}
