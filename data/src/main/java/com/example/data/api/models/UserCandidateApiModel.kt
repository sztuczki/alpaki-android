package com.example.data.api.models

data class UserCandidateApiModel(
    val name: String?,
    val surname: String?,
    val phone: String?,
    val email: String?,
    val password: String?,
    val activationCode: String?
)