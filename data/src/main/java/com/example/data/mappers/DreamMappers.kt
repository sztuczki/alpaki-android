package com.example.data.mappers

import com.example.data.api.models.DreamApiModel
import com.example.domain.models.Dream

fun DreamApiModel.toDomain(): Dream =
    Dream(
        dreamId,
        displayName,
        age ?: 0,
        dreamUrl,
        dreamCategory?.toDomain(),
        tags
    )

fun List<DreamApiModel>.toDomainList(): List<Dream> = map { it.toDomain() }