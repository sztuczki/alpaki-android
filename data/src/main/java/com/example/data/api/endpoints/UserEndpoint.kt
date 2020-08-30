package com.example.data.api.endpoints

import com.example.data.api.models.responses.user.GetUserMeResponse
import retrofit2.http.GET

interface UserEndpoint {

    @GET("api/User/me")
    suspend fun getMyInformation() : GetUserMeResponse
}