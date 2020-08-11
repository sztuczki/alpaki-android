package com.example.data.mappers

import com.example.data.api.ITEM_ID_INVALID
import com.example.data.api.models.DreamerApiModel
import com.example.domain.models.Dreamer

fun DreamerApiModel.toDomain() = Dreamer(
    dreamId ?: ITEM_ID_INVALID,
    firstName,
    lastName,
    age ?: 0,
    gender ?: 0,
    dreamUrl,
    tags
)

fun List<DreamerApiModel>.toDomainList(): List<Dreamer> = map { it.toDomain() }