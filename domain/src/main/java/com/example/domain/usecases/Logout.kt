package com.example.domain.usecases

import com.example.domain.repositories.TokenRepository
import com.example.domain.usecases.base.None
import com.example.domain.usecases.base.UseCase
import javax.inject.Inject

class Logout @Inject constructor(
    private val tokenRepository: TokenRepository
) : UseCase<None, Unit>() {

    override suspend fun run(params: None) =
        tokenRepository.clearToken()

    // Add clearing database
}