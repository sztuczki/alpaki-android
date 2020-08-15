package com.example.data.api.services

import com.example.data.database.dao.DreamCategoryDao
import com.example.data.mappers.toEntity
import com.example.domain.models.DreamCategory
import javax.inject.Inject

class CategoriesLocalService @Inject constructor(
    private val dreamCategoryDao: DreamCategoryDao
) {
    fun insertCategory(dreamCategory: DreamCategory) =
        dreamCategoryDao.insert(dreamCategory.toEntity())

    fun getAllCategories() = dreamCategoryDao.getAll()

    fun deleteCategory(dreamCategory: DreamCategory) =
        dreamCategoryDao.delete(dreamCategory.toEntity())
}