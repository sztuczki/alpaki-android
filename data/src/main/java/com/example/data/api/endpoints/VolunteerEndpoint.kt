package com.example.data.api.endpoints

import com.example.data.api.models.responses.PostVolunteerResponse
import com.example.domain.usecases.Register
import retrofit2.http.Body
import retrofit2.http.POST

interface VolunteerEndpoint {

    @POST("/api/Volunteers")
    suspend fun postVolunteer(
        @Body user: Register.Params
    ): PostVolunteerResponse
}