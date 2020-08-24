package com.example.data.repositories

import com.example.data.api.services.CategoriesApiService
import com.example.data.api.services.CategoriesLocalService
import com.example.data.database.entites.DreamCategoryEntity
import com.example.data.mappers.toDomain
import com.example.domain.models.DreamCategory
import com.example.domain.repositories.CategoriesRepository
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(
    private val categoriesApiService: CategoriesApiService,
    private val categoriesLocalService: CategoriesLocalService
) : CategoriesRepository {

    override suspend fun getCategories(): List<DreamCategory> =
        categoriesApiService.getCategories().also {
//            TODO: save categories
        }

    override suspend fun deleteCategory(category: DreamCategory) =
        categoriesLocalService.deleteCategory(category)
}