package com.example.data.api.models.responses

import com.example.data.api.models.DreamCategory2ApiModel

data class GetCategoriesResponse(
    val categories: List<DreamCategory2ApiModel>
)