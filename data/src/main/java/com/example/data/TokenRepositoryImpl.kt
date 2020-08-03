package com.example.data

import com.example.data.dataSource.local.TokenLocalDataSource
import com.example.data.dataSource.remote.TokenRemoteDataSource
import com.example.data.repository.TokenRepository

class TokenRepositoryImpl(
    val tokenLocalDataSource: TokenLocalDataSource,
    val tokenRemoteDataSource: TokenRemoteDataSource
): TokenRepository {

    override fun login(email: String, password: String) {
        tokenRemoteDataSource.getToken(email, password).
    }


}
