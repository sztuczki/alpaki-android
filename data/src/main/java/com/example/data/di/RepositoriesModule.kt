package com.example.data.di

import com.example.data.repositories.CategoriesRepositoryImpl
import com.example.data.repositories.DreamersRepositoryImpl
import com.example.data.repositories.TokenRepositoryImpl
import com.example.data.repositories.UserRepositoryImpl
import com.example.data.repositories.VolunteerRepositoryImpl
import com.example.domain.repositories.CategoriesRepository
import com.example.domain.repositories.DreamersRepository
import com.example.domain.repositories.TokenRepository
import com.example.domain.repositories.UserRepository
import com.example.domain.repositories.VolunteerRepository
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

    @Binds
    fun bindDreamersRepository(repository: DreamersRepositoryImpl): DreamersRepository

    @Binds
    fun bindVolunteersRepository(repository: VolunteerRepositoryImpl): VolunteerRepository

    @Binds
    fun bindUserRepository(repository: UserRepositoryImpl): UserRepository

}