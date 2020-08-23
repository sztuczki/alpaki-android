package com.example.domain.usecases

import com.example.domain.repositories.VolunteerRepository
import com.example.domain.usecases.base.UseCase
import javax.inject.Inject

class Register @Inject constructor(
    private val volunteerRepository: VolunteerRepository
) :
    UseCase<Register.Params, Unit>() {

    override suspend fun run(params: Params) =
        volunteerRepository.registerVolunteer(params)

    data class Params(
        val firstName: String,
        val lastName: String,
        val brand: String,
        val phoneNumber: String,
        val email: String,
        val code: String,
        val password: String
    )
}
