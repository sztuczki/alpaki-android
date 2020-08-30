package com.example.data.api.models

data class DreamApiModel(
    val dreamId: Long,
    val title: String?,
    val displayName: String?,
    val age: Int?,
    val dreamUrl: String?,
    val dreamCategory: DreamCategoryApiModel?,
    val tags: String?
)
