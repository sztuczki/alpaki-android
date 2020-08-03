package com.example.data.repository

interface TokenRepository {
    fun login(email: String, password: String)
}
