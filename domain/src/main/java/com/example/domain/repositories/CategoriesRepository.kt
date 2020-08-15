package com.example.domain.repositories

import com.example.domain.models.DreamCategory

interface CategoriesRepository {

    suspend fun getCategories(): List<DreamCategory>

    suspend fun saveCategories()

    suspend fun deleteCategory(category: DreamCategory)
}