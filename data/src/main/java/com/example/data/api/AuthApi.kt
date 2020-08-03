package com.example.data.api

interface AuthApi {
    // Here will be endpoint to authentication
    suspend fun getToken(email: String, password: String): String

    suspend fun resetPassword(email: String)
}
