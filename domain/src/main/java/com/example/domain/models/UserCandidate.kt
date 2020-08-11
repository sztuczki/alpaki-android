package com.example.domain.models

data class UserCandidate(
    val name: String,
    val surname: String,
    val phone: String,
    val email: String,
    val password: String,
    val activationCode: String
)
