package com.example.domain.repositories

import com.example.domain.usecases.Login

interface TokenRepository {
    suspend fun logIn(params: Login.Params)
    suspend fun clearToken()
}
