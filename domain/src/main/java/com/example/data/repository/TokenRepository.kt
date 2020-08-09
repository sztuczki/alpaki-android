package com.example.data.repository

interface TokenRepository {
    suspend fun logIn(email: String, password: String)
}
