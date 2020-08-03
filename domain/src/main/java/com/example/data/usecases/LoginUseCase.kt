package com.example.data.usecases

import com.example.data.repository.TokenRepository
import com.example.data.usecases.base.UseCase
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val tokenRepository: TokenRepository) :
    UseCase<LoginUseCase.Params, Unit>() {

    override suspend fun run(params: Params) =
        tokenRepository.logIn(params.email, params.password)

    data class Params(val email: String, val password: String)
}
