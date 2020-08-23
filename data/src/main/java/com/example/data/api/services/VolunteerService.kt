package com.example.data.api.services

import com.example.data.api.endpoints.VolunteerEndpoint
import com.example.data.api.services.base.ApiService
import com.example.domain.models.VolunteerCandidate
import com.example.domain.usecases.Register
import javax.inject.Inject

interface VolunteerService {
    suspend fun registerVolunteer(params: Register.Params): VolunteerCandidate
}

class VolunteerApiService @Inject constructor(
    private val endpoint: VolunteerEndpoint
) : ApiService(), VolunteerService {

    override suspend fun registerVolunteer(params: Register.Params): VolunteerCandidate {
        request {
            endpoint.postVolunteer(
                params
            )
        }.apply {
            return VolunteerCandidate(userId, token)
        }
    }
}
