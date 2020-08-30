package com.example.data.mappers

import com.example.data.api.models.DreamApiModel
import com.example.data.api.models.DreamModel
import com.example.domain.models.Dream

fun DreamApiModel.toDomain(): Dream =
    Dream(
        dreamId,
        title,
        displayName,
        age ?: 0,
        dreamUrl,
        dreamCategory?.toDomain(),
        tags
    )

fun List<DreamApiModel>.toDomainList(): List<Dream> = map { it.toDomain() }

fun Dream.toDreamModel() = DreamModel(
    id = dreamId,
    categoryName = dreamCategory?.dreamCategoryName.orEmpty(),
    dreamerName = displayName.orEmpty(),
    title = title.orEmpty(),
    age = age,
    dreamerCity = "", // TODO add this when backend will add city to dream
    dreamPercent = 0,
    imageUrl = "https://i.imgur.com/H357yaH.jpg",
    tags = tags.orEmpty()
)