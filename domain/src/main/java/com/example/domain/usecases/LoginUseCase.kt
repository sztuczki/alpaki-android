package com.example.domain.usecases

import com.example.domain.repositories.TokenRepository
import com.example.domain.usecases.base.UseCase
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val tokenRepository: TokenRepository) :
    UseCase<LoginUseCase.Params, Unit>() {

    override suspend fun run(params: Params) =
        tokenRepository.logIn(params.email, params.password)

    data class Params(val email: String, val password: String)
}
