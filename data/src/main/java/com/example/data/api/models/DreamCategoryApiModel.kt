package com.example.data.api.models

import com.google.gson.annotations.SerializedName

class DreamCategoryApiModel(
    @SerializedName("categoryId")
    val dreamCategoryId: Long,
    @SerializedName("categoryName")
    val categoryName: String?
)