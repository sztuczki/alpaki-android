package com.example.data.repositories

import com.example.data.api.TOKEN_KEY
import com.example.data.api.services.VolunteerService
import com.example.data.database.SharedPreferenceHandler
import com.example.domain.repositories.VolunteerRepository
import com.example.domain.usecases.Register
import javax.inject.Inject

class VolunteerRepositoryImpl @Inject constructor(
    private val volunteerService: VolunteerService,
    private val preferences: SharedPreferenceHandler
) : VolunteerRepository {

    override suspend fun registerVolunteer(params: Register.Params) {
        volunteerService.registerVolunteer(params).run {
            preferences.putString(TOKEN_KEY, token)
        }
    }
}