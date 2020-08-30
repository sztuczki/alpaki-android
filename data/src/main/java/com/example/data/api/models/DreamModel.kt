package com.example.data.api.models

data class DreamModel(
    val id: Long,
    val categoryName: String,
    val title: String,
    val dreamerName: String,
    val age: Int,
    val dreamerCity: String,
    var dreamPercent: Int,
    val imageUrl: String,
    val tags: String
)