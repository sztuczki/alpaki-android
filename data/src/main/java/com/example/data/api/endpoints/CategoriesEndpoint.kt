package com.example.data.api.endpoints

import com.example.data.api.models.responses.GetCategoriesResponse
import retrofit2.http.GET

interface CategoriesEndpoint {

    @GET("api/Categories")
    suspend fun getCategories(): GetCategoriesResponse
}