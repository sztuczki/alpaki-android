package com.example.data.di

import com.example.data.TokenRepositoryImpl
import com.example.data.repositories.CategoriesRepositoryImpl
import com.example.domain.repositories.CategoriesRepository
import com.example.domain.repositories.TokenRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoriesModule

@Module
@InstallIn(ActivityRetainedComponent::class)
interface RepositoriesBindings {

    @Binds
    fun bindTokenRepository(tokenRepositoryImpl: TokenRepositoryImpl): TokenRepository

    @Binds
    fun bindCategoriesRepository(repository: CategoriesRepositoryImpl): CategoriesRepository
}