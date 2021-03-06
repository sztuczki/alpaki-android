package com.example.data.api.endpoints

import com.example.data.api.PARAM_DREAMERS_AGE_FROM
import com.example.data.api.PARAM_DREAMERS_AGE_TO
import com.example.data.api.PARAM_DREAMERS_ASC
import com.example.data.api.PARAM_DREAMERS_CATEGORIES
import com.example.data.api.PARAM_DREAMERS_GENDER
import com.example.data.api.PARAM_DREAMERS_ORDER_BY
import com.example.data.api.PARAM_DREAMERS_PAGE
import com.example.data.api.PARAM_DREAMERS_SEARCH_NAME
import com.example.data.api.PARAM_DREAMERS_STATUS
import com.example.data.api.models.responses.GetDreamsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DreamsEndpoint {

    @GET("api/Dreams")
    suspend fun getDreams(
        @Query(PARAM_DREAMERS_SEARCH_NAME) searchName: String?,
        @Query(PARAM_DREAMERS_GENDER) gender: Int?,
        @Query(PARAM_DREAMERS_STATUS) status: Int?,
        @Query(PARAM_DREAMERS_AGE_FROM) ageFrom: Int?,
        @Query(PARAM_DREAMERS_AGE_TO) ageTo: Int?,
        @Query(PARAM_DREAMERS_CATEGORIES) categories: Array<Int>?,
        @Query(PARAM_DREAMERS_ASC) asc: Boolean?,
        @Query(PARAM_DREAMERS_ORDER_BY) orderBy: String?,
        @Query(PARAM_DREAMERS_PAGE) page: Int?
    ): GetDreamsResponse
}