package com.example.data.api.endpoints

import com.example.data.api.*
import com.example.data.api.models.responses.GetDreamersResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface DreamersEndpoint {

    //    TODO: replace this with interceptor once signing in is implemented
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1laWQiOiIxIiwidW5pcXVlX25hbWUiOiIxIiwicm9sZSI6IjciLCJuYmYiOjE1OTc0MjAyNTAsImV4cCI6MTYyODk0OTA1MCwiaWF0IjoxNTk3NDIwMjUwfQ.8s5JNh7gEWGIlOOZpjIl6CV5m2_JWg8AdgzQlCWvr5I")
    @GET("api/Dreamers")
    suspend fun getDreamers(
        @Query(PARAM_DREAMERS_SEARCH_NAME) searchName: String?,
        @Query(PARAM_DREAMERS_GENDER) gender: Int?,
        @Query(PARAM_DREAMERS_STATUS) status: Int?,
        @Query(PARAM_DREAMERS_AGE_FROM) ageFrom: Int?,
        @Query(PARAM_DREAMERS_AGE_TO) ageTo: Int?,
        @Query(PARAM_DREAMERS_CATEGORIES) categories: Array<Int>?,
        @Query(PARAM_DREAMERS_ASC) asc: Boolean?,
        @Query(PARAM_DREAMERS_ORDER_BY) orderBy: String?,
        @Query(PARAM_DREAMERS_PAGE) page: Int?
    ): GetDreamersResponse
}