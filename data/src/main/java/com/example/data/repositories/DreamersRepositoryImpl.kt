package com.example.data.repositories

import com.example.data.api.services.DreamersService
import com.example.domain.models.Dreamer
import com.example.domain.repositories.DreamersRepository
import com.example.domain.usecases.base.GetDreamers
import javax.inject.Inject

class DreamersRepositoryImpl @Inject constructor(
    private val dreamersService: DreamersService
) : DreamersRepository {

    override suspend fun getDreamers(params: GetDreamers.Params?): List<Dreamer> {
        return dreamersService.getDreamers(params)
    }
}