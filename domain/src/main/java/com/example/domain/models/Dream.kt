package com.example.domain.models

data class Dream(
    val dreamId: Long,
    val displayName: String?,
    val age: Int,
    val dreamUrl: String?,
    val dreamCategory: Category?,
    val tags: String?
)