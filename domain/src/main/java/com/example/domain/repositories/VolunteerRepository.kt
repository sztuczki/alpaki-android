package com.example.domain.repositories

import com.example.domain.usecases.Register

interface VolunteerRepository {
    suspend fun registerVolunteer(params: Register.Params)
}