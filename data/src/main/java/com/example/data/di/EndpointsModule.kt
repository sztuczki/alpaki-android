package com.example.data.di

import com.example.data.api.endpoints.AuthorizationEndpoint
import com.example.data.api.endpoints.CategoriesEndpoint
import com.example.data.api.endpoints.DreamsEndpoint
import com.example.data.api.endpoints.UserEndpoint
import com.example.data.api.endpoints.VolunteerEndpoint
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

    @Provides
    fun provideDreamersEndpoint(retrofit: Retrofit): DreamsEndpoint {
        return retrofit.create(DreamsEndpoint::class.java)
    }

    @Provides
    fun provideAuthorizationEndpoint(retrofit: Retrofit): AuthorizationEndpoint {
        return retrofit.create(AuthorizationEndpoint::class.java)
    }

    @Provides
    fun provideVolunteerEndpoint(retrofit: Retrofit): VolunteerEndpoint {
        return retrofit.create(VolunteerEndpoint::class.java)
    }

    @Provides
    fun provideUserEndpoint(retrofit: Retrofit): UserEndpoint {
        return retrofit.create(UserEndpoint::class.java)
    }
}