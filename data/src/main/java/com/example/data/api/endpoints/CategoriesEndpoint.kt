package com.example.data.api.endpoints

import com.example.data.api.models.responses.GetCategoriesResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface CategoriesEndpoint {

    //    TODO: replace this with interceptor once signing in is implemented
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1laWQiOiIxIiwidW5pcXVlX25hbWUiOiIxIiwicm9sZSI6IjciLCJuYmYiOjE1OTc0MjAyNTAsImV4cCI6MTYyODk0OTA1MCwiaWF0IjoxNTk3NDIwMjUwfQ.8s5JNh7gEWGIlOOZpjIl6CV5m2_JWg8AdgzQlCWvr5I")
    @GET("api/Categories")
    suspend fun getCategories(): GetCategoriesResponse
}