package com.example.data.api.models.responses

import com.example.data.api.models.DreamApiModel

data class GetDreamsResponse(
    val dreams: List<DreamApiModel>
)