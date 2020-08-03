package com.example.data.dataSource.remote

import com.example.data.api.AuthApi

class TokenRemoteDataSource(
    private val api: AuthApi
) {
    suspend fun getToken(email: String, password: String): String =
        api.getToken(email, password)

    suspend fun resetPassword(email: String) =
        api.resetPassword(email)
}
