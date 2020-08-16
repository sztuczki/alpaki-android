package com.example.data.api.services

import com.example.data.api.endpoints.DreamersEndpoint
import com.example.data.api.services.base.ApiService
import com.example.data.mappers.toDomainList
import com.example.domain.models.Dreamer
import com.example.domain.usecases.base.GetDreamers
import javax.inject.Inject

interface DreamersService {

    suspend fun getDreamers(params: GetDreamers.Params?): List<Dreamer>
}

class DreamersApiService @Inject constructor(
    private val endpoint: DreamersEndpoint
) : ApiService(), DreamersService {

    override suspend fun getDreamers(params: GetDreamers.Params?): List<Dreamer> =
        endpoint.getDreamers(
            params?.searchName,
            params?.gender,
            params?.status,
            params?.ageFrom,
            params?.ageTo,
            params?.categories,
            params?.asc,
            params?.orderBy,
            params?.page
        ).dreams.toDomainList()
}