package com.example.data.di

import com.example.data.api.services.CategoriesApiService
import com.example.data.api.services.CategoriesService
import com.example.data.api.services.DreamersApiService
import com.example.data.api.services.DreamersService
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
}