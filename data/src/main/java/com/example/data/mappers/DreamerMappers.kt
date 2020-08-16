package com.example.data.mappers

import com.example.data.api.models.DreamerApiModel
import com.example.domain.models.Dreamer

fun DreamerApiModel.toDomain() = Dreamer(
    dreamId,
    firstName,
    lastName,
    age ?: 0,
    gender ?: 0,
    dreamUrl,
    tags
)

fun List<DreamerApiModel>.toDomainList(): List<Dreamer> = map { it.toDomain() }