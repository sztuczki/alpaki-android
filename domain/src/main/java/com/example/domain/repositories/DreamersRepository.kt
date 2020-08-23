package com.example.domain.repositories

import com.example.domain.models.Dream
import com.example.domain.usecases.GetDreams

interface DreamersRepository {

    suspend fun getDreams(params: GetDreams.Params?): List<Dream>
}