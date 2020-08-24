package com.example.data.database.dao

import androidx.room.*
import com.example.data.database.entites.DreamCategoryEntity

@Dao
interface DreamCategoryDao {
    @Query("SELECT * FROM DreamCategory")
    suspend fun getAll(): List<DreamCategoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(categoryEntity: DreamCategoryEntity)

    @Delete
    suspend fun delete(categoryEntity: DreamCategoryEntity)
}