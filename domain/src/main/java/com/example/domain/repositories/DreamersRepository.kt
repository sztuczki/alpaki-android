package com.example.domain.repositories

import com.example.domain.models.Dreamer
import com.example.domain.usecases.base.GetDreamers

interface DreamersRepository {

    suspend fun getDreamers(params: GetDreamers.Params?): List<Dreamer>
}