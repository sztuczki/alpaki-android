package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.database.dao.DreamCategoryDao
import com.example.data.database.entites.DreamCategoryEntity

@Database(entities = [DreamCategoryEntity::class], version = 1, exportSchema = false)
abstract class AlpakiDB : RoomDatabase() {
    abstract fun dreamCategoryDao(): DreamCategoryDao
}