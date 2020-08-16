package com.example.alpaki

//temporary dream model used in active_dream_card_view.xml

data class DreamModel(
    val id: Int,
    val categoryName: String,
    val dreamName: String,
    val dreamerName: String,
    val dreamerAge: Int,
    val dreamerCity: String,
    var dreamPercent: Int,
    val imageUrl: String
)