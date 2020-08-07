package com.example.data.di

import com.example.data.TokenRepositoryImpl
import com.example.data.dataSource.local.TokenLocalDataSource
import com.example.data.dataSource.remote.TokenRemoteDataSource
import com.example.data.repository.TokenRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module()
@InstallIn(ApplicationComponent::class)
interface RepositoryBindings {

    @Binds
    fun bindTokenRepository(tokenRepositoryImpl: TokenRepositoryImpl): TokenRepository
}
@Module
@InstallIn(ApplicationComponent::class)
object DataComponentModule {

    @Singleton
    @Provides
    fun provideTokenLocalDataSource() = TokenLocalDataSource()

    @Singleton
    @Provides
    fun provideTokenRemoteDataSource() = TokenRemoteDataSource()
}
