package com.example.data.api.endpoints

import com.example.data.api.*
import com.example.data.api.models.responses.GetDreamersResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface DreamersEndpoint {

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