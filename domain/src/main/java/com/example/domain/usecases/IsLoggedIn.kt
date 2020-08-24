package com.example.domain.usecases

import com.example.domain.repositories.TokenRepository
import com.example.domain.usecases.base.None
import com.example.domain.usecases.base.UseCase
import javax.inject.Inject

class IsLoggedIn @Inject constructor(
    private val tokenRepository: TokenRepository
) : UseCase<None, Boolean>() {

    override suspend fun run(params: None) =
        tokenRepository.getToken().isNullOrEmpty().not()
}