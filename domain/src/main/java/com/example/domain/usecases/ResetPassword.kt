package com.example.domain.usecases

import com.example.domain.usecases.base.UseCase
import javax.inject.Inject

//Fixing that UseCase in next PR
class ResetPassword @Inject constructor(

) :
    UseCase<ResetPassword.Params, Unit>() {

    override suspend fun run(params: Params) = Unit

    data class Params(val email: String)
}
