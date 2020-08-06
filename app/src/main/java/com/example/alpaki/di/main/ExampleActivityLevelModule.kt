package com.example.alpaki.di.main

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
//    TODO: this cannot be @Singleton as this is Activity-level module
//    Singletons can only be declared in Application-level module: @InstallIn(ApplicationComponent::class)
    fun provideLoginUseCase(tokenRepository: TokenRepository): LoginUseCase = LoginUseCase(tokenRepository)
}
