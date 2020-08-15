package com.example.data.di

import android.app.Application
import androidx.room.Room
import com.example.data.database.AlpakiDB
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
    fun provideAlpakiDb(application: Application): AlpakiDB {
        return Room.databaseBuilder(application, AlpakiDB::class.java, "AlpakiDatabase")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun provideDreamCategoryDao(alpakiDB: AlpakiDB): DreamCategoryDao {
        return alpakiDB.dreamCategoryDao()
    }
}