package com.example.data.dataSource.local

interface LocalTokenSettings {
    fun saveToken(token: String)

    fun retrieveToken(): String?

    fun deleteTokens()
}
