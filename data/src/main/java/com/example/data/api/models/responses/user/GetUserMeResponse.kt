package com.example.data.api.models.responses.user

data class GetUserMeResponse(
    val userId: Long,
    val userRole: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val brand: String?,
    val phoneNumber: String?,
    val profileImageUrl: String?
)
