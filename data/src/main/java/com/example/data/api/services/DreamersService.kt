package com.example.data.api.services

import com.example.data.api.endpoints.DreamsEndpoint
import com.example.data.api.services.base.ApiService
import com.example.data.mappers.toDomainList
import com.example.domain.models.Dream
import com.example.domain.usecases.GetDreams
import javax.inject.Inject

interface DreamersService {

    suspend fun getDreams(params: GetDreams.Params?): List<Dream>
}

class DreamersApiService @Inject constructor(
    private val endpoint: DreamsEndpoint
) : ApiService(), DreamersService {

    override suspend fun getDreams(params: GetDreams.Params?): List<Dream> =
        endpoint.getDreams(
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