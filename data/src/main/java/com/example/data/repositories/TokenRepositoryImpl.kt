package com.example.data.repositories

import com.example.data.api.TOKEN_KEY
import com.example.data.api.services.TokenService
import com.example.data.database.SharedPreferenceHandler
import com.example.domain.repositories.TokenRepository
import com.example.domain.usecases.Login
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(
    private val tokenService: TokenService,
    private val preferences: SharedPreferenceHandler
) : TokenRepository {

    override suspend fun logIn(params: Login.Params) {
        tokenService.getToken(params).run {
            preferences.putString(TOKEN_KEY, this)
        }
    }

    override suspend fun clearToken() = preferences.clear()

    override suspend fun getToken() =
        preferences.getString(TOKEN_KEY)
}
