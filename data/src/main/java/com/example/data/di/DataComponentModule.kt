package com.example.data.di

import android.content.Context
import com.example.data.TokenRepositoryImpl
import com.example.data.repository.TokenRepository
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Component(dependencies = [DataComponent::class], modules = [])
interface DataComponent {

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(dataComponent: DataComponent): Builder
        fun build(): DataComponent
    }

    @Binds
    fun bindTokenRepository(
        tokenRepositoryImpl: TokenRepositoryImpl
    ): TokenRepository
}
