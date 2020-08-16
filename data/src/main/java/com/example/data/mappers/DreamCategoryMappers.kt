package com.example.data.mappers

import com.example.data.api.models.DreamCategoryApiModel
import com.example.data.database.entites.DreamCategoryEntity
import com.example.domain.models.DreamCategory


fun DreamCategoryApiModel.toDomain(): DreamCategory =
    DreamCategory(
        dreamCategoryId,
        categoryName.orEmpty()
    )

fun DreamCategory.toEntity() = DreamCategoryEntity(
    dreamCategoryId,
    categoryName
)

fun DreamCategoryEntity.toDomain() = DreamCategory(
    dreamCategoryId,
    categoryName
)

fun List<DreamCategoryApiModel>.toDomainList(): List<DreamCategory> = map { it.toDomain() }