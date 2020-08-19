package com.example.domain.repositories

import com.example.domain.models.Dream
import com.example.domain.usecases.base.GetDreamers

interface DreamersRepository {

    suspend fun getDreamers(params: GetDreamers.Params?): List<Dream>
}