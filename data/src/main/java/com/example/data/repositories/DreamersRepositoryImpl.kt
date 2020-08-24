package com.example.data.repositories

import com.example.data.api.services.DreamersService
import com.example.domain.models.Dream
import com.example.domain.repositories.DreamersRepository
import com.example.domain.usecases.GetDreams
import javax.inject.Inject

class DreamersRepositoryImpl @Inject constructor(
    private val dreamersService: DreamersService
) : DreamersRepository {

    override suspend fun getDreams(params: GetDreams.Params?): List<Dream> {
        return dreamersService.getDreams(params)
    }
}