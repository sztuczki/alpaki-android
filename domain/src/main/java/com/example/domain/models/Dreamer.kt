package com.example.domain.models

data class Dreamer(
    val dreamId: Long,
    val firstName: String?,
    val lastName: String?,
    val age: Int,
    val gender: Int,
    val dreamUrl: String?,
    val tags: String?
)