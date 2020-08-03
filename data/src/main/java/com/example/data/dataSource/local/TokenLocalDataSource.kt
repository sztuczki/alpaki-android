package com.example.data.dataSource.local

class TokenLocalDataSource(
    private val localTokenSettings: LocalTokenSettings
) {
    fun saveToken(token: String) =
        localTokenSettings.saveToken(token)

    fun retrieveToken() = localTokenSettings.retrieveToken()

    fun deleteToken() = localTokenSettings.deleteTokens()
}
