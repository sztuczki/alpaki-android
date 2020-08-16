package com.example.data.database.dao

import androidx.room.*
import com.example.data.database.entites.DreamCategoryEntity

@Dao
interface DreamCategoryDao {
    @Query("SELECT * FROM DreamCategory")
    fun getAll(): List<DreamCategoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dreamCategoryEntity: DreamCategoryEntity)

    @Delete
    fun delete(dreamCategoryEntity: DreamCategoryEntity)
}