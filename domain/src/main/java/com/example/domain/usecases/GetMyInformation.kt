package com.example.domain.usecases

import com.example.domain.models.UserDetails
import com.example.domain.repositories.UserRepository
import com.example.domain.usecases.base.None
import com.example.domain.usecases.base.UseCase
import javax.inject.Inject

class GetMyInformation @Inject constructor(
    private val userRepository: UserRepository
) : UseCase<None, UserDetails>() {

    override suspend fun run(params: None): UserDetails =
        userRepository.getMyInformation()
}
