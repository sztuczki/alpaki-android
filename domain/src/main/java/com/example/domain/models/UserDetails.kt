package com.example.domain.models

data class UserDetails(
    val userId: Long,
    val userRole: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val brand: String?,
    val phoneNumber: String?,
    val profileImageUrl: String?
)
