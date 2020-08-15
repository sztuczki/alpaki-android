package com.example.data.di

import android.app.Application
import androidx.room.Room
import com.example.data.database.AlpakiDatabase
import com.example.data.database.dao.DreamCategoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAlpakiDb(application: Application): AlpakiDatabase {
        return Room.databaseBuilder(application, AlpakiDatabase::class.java, "AlpakiDatabase")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun AlpakiDatabase.provideDreamCategoryDao(): DreamCategoryDao {
        return dreamCategoryDao()
    }
}