package com.example.domain.usecases

import com.example.domain.models.UserCandidate
import com.example.domain.repositories.TokenRepository
import com.example.domain.usecases.base.UseCase
import javax.inject.Inject

//Fixing that UseCase in next PR
class Register @Inject constructor(

) :
    UseCase<Register.Params, Unit>() {

    override suspend fun run(params: Params) = Unit

    data class Params(val userCandidate: UserCandidate)
}
