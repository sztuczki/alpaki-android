package com.example.data.api.services

import com.example.data.api.endpoints.UserEndpoint
import com.example.data.api.services.base.ApiService
import com.example.domain.models.UserDetails
import javax.inject.Inject

interface UserService {

    suspend fun getMyInformation(): UserDetails
}

class UserApiService @Inject constructor(
    private val endpoint: UserEndpoint
) : ApiService(), UserService {

    override suspend fun getMyInformation(): UserDetails {
        request {
            endpoint.getMyInformation()
        }.apply {
            return UserDetails(
                userId,
                userRole,
                firstName,
                lastName,
                email,
                brand,
                phoneNumber,
                profileImageUrl
            )
        }
    }
}