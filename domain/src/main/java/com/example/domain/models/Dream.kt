package com.example.domain.models

data class Dream(
    val dreamId: Long,
    val title: String?,
    val displayName: String?,
    val age: Int,
    val dreamUrl: String?,
    val dreamCategory: DreamCategory?,
    val tags: String?
)