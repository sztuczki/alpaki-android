package com.example.data.repositories

import com.example.data.dataSource.local.TokenLocalDataSource
import com.example.data.dataSource.remote.TokenRemoteDataSource
import com.example.domain.models.UserCandidate
import com.example.domain.repositories.TokenRepository
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(
    private val tokenLocalDataSource: TokenLocalDataSource,
    private val tokenRemoteDataSource: TokenRemoteDataSource
) : TokenRepository {

    override suspend fun logIn(email: String, password: String) {
        // finish after connecting with backend
    }

    override suspend fun register(userCandidate: UserCandidate) {
        // finish after connecting with backend
    }

    override suspend fun resetPassword(email: String) {
        // finish after connecting with backend
    }
}
