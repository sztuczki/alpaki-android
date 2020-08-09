package com.example.domain.repositories

interface TokenRepository {
    suspend fun logIn(email: String, password: String)
}
