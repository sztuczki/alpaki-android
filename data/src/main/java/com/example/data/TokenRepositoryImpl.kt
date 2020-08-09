package com.example.data

import com.example.data.dataSource.local.TokenLocalDataSource
import com.example.data.dataSource.remote.TokenRemoteDataSource
import com.example.domain.repositories.TokenRepository
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(
    private val tokenLocalDataSource: TokenLocalDataSource,
    private val tokenRemoteDataSource: TokenRemoteDataSource
) : TokenRepository {

    /*  override suspend fun logIn(email: String, password: String) = Unit*/

    override suspend fun logIn(email: String, password: String) {
        tokenLocalDataSource.toString()
        /*tokenRemoteDataSource.getToken(email, password).apply {
            tokenLocalDataSource.saveToken(this)
        }*/
    }
}
