package com.example.data.mappers

import com.example.data.api.models.CategoryApiModel
import com.example.domain.models.Category

fun CategoryApiModel.toDomain(): Category {
    return Category(
        dreamCategoryId,
        dreamCategoryName.orEmpty()
    )
}