package com.example.domain.models

data class Sponsor(
    val id: Long,
    val logoUrl: String?,
    var isFavourite: Boolean
)