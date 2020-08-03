package com.example.data

import com.example.data.dataSource.local.TokenLocalDataSource
import com.example.data.dataSource.remote.TokenRemoteDataSource
import com.example.data.repository.TokenRepository

class TokenRepositoryImpl(
    private val tokenLocalDataSource: TokenLocalDataSource,
    private val tokenRemoteDataSource: TokenRemoteDataSource
) : TokenRepository {

    override suspend fun logIn(email: String, password: String) {
        tokenRemoteDataSource.getToken(email, password).apply {
            tokenLocalDataSource.saveToken(this)
        }
    }

}
