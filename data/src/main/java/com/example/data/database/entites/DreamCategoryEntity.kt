package com.example.data.database.entites

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DreamCategory")
data class DreamCategoryEntity(
    @PrimaryKey
    val dreamCategoryId: Long,
    val categoryName: String
)