package com.example.domain.models

data class Dreamer(
    val dreamId: Long,
    val firstName: String?,
    val lastName: String?,
    val age: Int,
    val gender: Int,
    val dreamUrl: String?,
    val tags: String?
) {

    val fullName: String
        get() = when {
            firstName.isNullOrEmpty() -> lastName.orEmpty()
            lastName.isNullOrEmpty() -> firstName.orEmpty()
            else -> "$firstName $lastName"
        }
}