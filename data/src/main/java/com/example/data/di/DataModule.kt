package com.example.data.di

import com.example.data.dataSource.local.TokenLocalDataSource
import com.example.data.dataSource.remote.TokenRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module(
    includes = [
        RepositoriesModule::class,
        RepositoriesBindings::class,
        ServicesModule::class,
        ServicesBindings::class,
        EndpointsModule::class
    ]
)
@InstallIn(ApplicationComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideTokenLocalDataSource() = TokenLocalDataSource()

    @Singleton
    @Provides
    fun provideTokenRemoteDataSource() = TokenRemoteDataSource()
}
