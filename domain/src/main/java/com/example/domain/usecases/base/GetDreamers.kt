package com.example.domain.usecases.base

import com.example.domain.models.Dreamer
import com.example.domain.repositories.DreamersRepository
import javax.inject.Inject

class GetDreamers @Inject constructor(
    private val dreamersRepository: DreamersRepository
) : UseCase<GetDreamers.Params?, List<Dreamer>>() {

    override suspend fun run(params: Params?): List<Dreamer> {
        return dreamersRepository.getDreamers(params)
    }

    data class Params(
        val searchName: String? = null,
        val gender: Int? = null,
        val status: Int? = null,
        val ageFrom: Int? = null,
        val ageTo: Int? = null,
        val categories: Array<Int>? = null,
        val asc: Boolean? = null,
        val orderBy: String? = null,
        val page: Int? = null
    )
}