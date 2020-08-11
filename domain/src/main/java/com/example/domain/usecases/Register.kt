package com.example.domain.usecases

import com.example.domain.models.UserCandidate
import com.example.domain.repositories.TokenRepository
import com.example.domain.usecases.base.UseCase
import javax.inject.Inject

class Register @Inject constructor(private val tokenRepository: TokenRepository) :
    UseCase<Register.Params, Unit>() {

    override suspend fun run(params: Params) =
        tokenRepository.register(params.userCandidate)

    data class Params(val userCandidate: UserCandidate)
}
