package com.example.data.dataSource.local

interface LocalTokenSettings {
    fun saveToken(token: String)
    fun deleteTokens()
}
