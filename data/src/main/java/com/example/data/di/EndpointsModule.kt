package com.example.data.di

import com.example.data.api.endpoints.CategoriesEndpoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
object EndpointsModule {

    @Provides
    fun provideCategoriesEndpoint(retrofit: Retrofit): CategoriesEndpoint {
        return retrofit.create(CategoriesEndpoint::class.java)
    }
}