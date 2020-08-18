package com.example.data.api.endpoints

import com.example.data.api.models.responses.GetAuthorizationResponse
import com.example.domain.usecases.Login
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthorizationEndpoint {

    @POST("api/Authorize")
    suspend fun getAuthorization(
        @Body params: Login.Params
    ): GetAuthorizationResponse
}