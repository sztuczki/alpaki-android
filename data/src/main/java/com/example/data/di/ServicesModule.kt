package com.example.data.di

import com.example.data.api.services.CategoriesApiService
import com.example.data.api.services.CategoriesService
import com.example.data.api.services.DreamersApiService
import com.example.data.api.services.DreamersService
import com.example.data.api.services.TokenApiService
import com.example.data.api.services.TokenService
import com.example.data.api.services.UserApiService
import com.example.data.api.services.UserService
import com.example.data.api.services.VolunteerApiService
import com.example.data.api.services.VolunteerService
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

    @Binds
    fun bindVolunteerService(service: VolunteerApiService): VolunteerService

    @Binds
    fun bindUserService(service: UserApiService): UserService
}