package com.example.domain.usecases

import com.example.domain.repositories.TokenRepository
import com.example.domain.usecases.base.UseCase
import javax.inject.Inject

class ResetPassword @Inject constructor(private val tokenRepository: TokenRepository) :
    UseCase<ResetPassword.Params, Unit>() {

    override suspend fun run(params: Params) =
        tokenRepository.resetPassword(params.email)

    data class Params(val email: String)
}
