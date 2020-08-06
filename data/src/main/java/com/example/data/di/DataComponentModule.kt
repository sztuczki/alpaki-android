package com.example.data.di

import com.example.data.TokenRepositoryImpl
import com.example.data.repository.TokenRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module()
@InstallIn(ApplicationComponent::class)
interface RepositoryBindings {

    @Binds
    fun bindTokenRepository(tokenRepositoryImpl: TokenRepositoryImpl): TokenRepository
}
