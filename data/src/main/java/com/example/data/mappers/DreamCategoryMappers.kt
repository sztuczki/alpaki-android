package com.example.data.mappers

import com.example.data.api.ITEM_ID_INVALID
import com.example.data.api.models.DreamCategoryApiModel
import com.example.domain.models.DreamCategory


fun DreamCategoryApiModel.toDomain(): DreamCategory =
    DreamCategory(
        dreamCategoryId ?: ITEM_ID_INVALID,
        categoryName.orEmpty()
    )

fun List<DreamCategoryApiModel>.toDomainList(): List<DreamCategory> = map { it.toDomain() }