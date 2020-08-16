package com.example.data.di

import com.example.data.api.services.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object ServicesModule

@Module
@InstallIn(ActivityRetainedComponent::class)
interface ServicesBindings {

    @Binds
    fun bindCategoriesService(service: CategoriesApiService): CategoriesService

    @Binds
    fun bindDreamersService(service: DreamersApiService): DreamersService

    @Binds
    fun bindTokenService(service: TokenApiService): TokenService
}