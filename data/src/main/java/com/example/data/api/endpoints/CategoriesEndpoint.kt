package com.example.data.api.endpoints

import com.example.data.api.models.responses.GetCategoriesResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface CategoriesEndpoint {

    //    TODO: replace this with interceptor once signing in is implemented
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1laWQiOiIxIiwidW5pcXVlX25hbWUiOiIxIiwicm9sZSI6IjciLCJuYmYiOjE1OTY5OTEzNzMsImV4cCI6MTYyODUyNzM3MywiaWF0IjoxNTk2OTkxMzczfQ.jNjvFmgmzbtbrdqWm8s67_xOe8fcdrptt1ydz3tbzSA")
    @GET("api/Categories")
    suspend fun getCategories(): GetCategoriesResponse
}