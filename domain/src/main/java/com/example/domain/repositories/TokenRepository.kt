package com.example.domain.repositories

import com.example.domain.models.UserCandidate

interface TokenRepository {
    suspend fun logIn(email: String, password: String)

    suspend fun register(userCandidate: UserCandidate)
}
