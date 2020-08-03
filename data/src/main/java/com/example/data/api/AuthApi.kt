package com.example.data.api

interface AuthApi {
    suspend fun getToken(email: String, password: String)

    suspend fun resetPassword(email: String)
}
