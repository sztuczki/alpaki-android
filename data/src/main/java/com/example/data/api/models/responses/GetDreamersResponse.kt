package com.example.data.api.models.responses

import com.example.data.api.models.DreamerApiModel

data class GetDreamersResponse(
    val dreams: List<DreamerApiModel>
)