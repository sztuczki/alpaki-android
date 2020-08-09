package com.example.data.api.services

import com.example.data.api.endpoints.CategoriesEndpoint
import com.example.data.api.services.base.ApiService
import com.example.data.mappers.toDomainList
import com.example.domain.models.DreamCategory
import javax.inject.Inject

interface CategoriesService {

    suspend fun getCategories(): List<DreamCategory>
}

class CategoriesApiService @Inject constructor(
    private val categoriesEndpoint: CategoriesEndpoint
) : ApiService(), CategoriesService {

    override suspend fun getCategories(): List<DreamCategory> =
        request { categoriesEndpoint.getCategories() }.categories.toDomainList()
}