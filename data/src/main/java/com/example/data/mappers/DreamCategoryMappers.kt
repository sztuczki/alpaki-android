package com.example.data.mappers

import com.example.data.api.models.DreamCategory2ApiModel
import com.example.data.api.models.DreamCategoryApiModel
import com.example.data.database.entites.DreamCategoryEntity
import com.example.domain.models.DreamCategory

fun DreamCategoryApiModel.toDomain(): DreamCategory {
    return DreamCategory(
        dreamCategoryId,
        dreamCategoryName.orEmpty()
    )
}

fun DreamCategory2ApiModel.toDomain(): DreamCategory {
    return DreamCategory(
        categoryId,
        categoryName.orEmpty()
    )
}

fun List<DreamCategoryApiModel>.toDomainList(): List<DreamCategory> {
    return map { it.toDomain() }
}

fun List<DreamCategory2ApiModel>.toDomainList2(): List<DreamCategory> {
    return map { it.toDomain() }
}

fun DreamCategory.toEntity(): DreamCategoryEntity =
    DreamCategoryEntity(
        dreamCategoryId,
        dreamCategoryName
    )

fun DreamCategoryEntity.toDomain(): DreamCategory =
    DreamCategory(
        dreamCategoryId,
        categoryName
    )