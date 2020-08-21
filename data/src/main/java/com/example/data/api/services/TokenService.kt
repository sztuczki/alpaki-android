package com.example.data.api.services

import com.example.data.api.endpoints.AuthorizationEndpoint
import com.example.data.api.services.base.ApiService
import com.example.domain.usecases.Login
import javax.inject.Inject

interface TokenService {
    suspend fun getToken(params: Login.Params): String
}

class TokenApiService @Inject constructor(
    private val authorizationEndpoint: AuthorizationEndpoint
) : ApiService(), TokenService {

    override suspend fun getToken(params: Login.Params): String =
        request { authorizationEndpoint.getAuthorization(params) }.token
}