package com.example.data.mappers

import com.example.data.api.models.UserCandidateApiModel
import com.example.domain.models.UserCandidate

fun UserCandidateApiModel.toDomain(): UserCandidate =
    UserCandidate(
        name.orEmpty(),
        surname.orEmpty(),
        phone.orEmpty(),
        email.orEmpty(),
        password.orEmpty(),
        activationCode.orEmpty()
    )