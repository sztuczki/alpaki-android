package com.example.data.repositories

import com.example.data.api.services.CategoriesService
import com.example.domain.models.DreamCategory
import com.example.domain.repositories.CategoriesRepository
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(
    private val categoriesService: CategoriesService
) : CategoriesRepository {

    override suspend fun getCategories(): List<DreamCategory> = categoriesService.getCategories()
}