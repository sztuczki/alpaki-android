package com.example.domain.repositories

import com.example.domain.models.UserDetails

interface UserRepository {

    suspend fun getMyInformation(): UserDetails
}