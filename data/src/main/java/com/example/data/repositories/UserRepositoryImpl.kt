package com.example.data.repositories

import com.example.data.api.services.UserService
import com.example.domain.repositories.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService
) : UserRepository {

    override suspend fun getMyInformation() =
        userService.getMyInformation()
}