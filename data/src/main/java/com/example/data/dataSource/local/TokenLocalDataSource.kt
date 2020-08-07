package com.example.data.dataSource.local

import javax.inject.Inject

//Add Dao file after connecting to the backend
class TokenLocalDataSource @Inject constructor() {
    fun saveToken(token: String) =
        Unit

    fun deleteToken() = Unit
}
