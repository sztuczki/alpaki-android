package com.example.data.api.services.base

abstract class ApiService {

    suspend fun <T> request(apiCall: suspend () -> T): T {
        return try {
            apiCall.invoke()
        } catch (throwable: Throwable) {
//            TODO: introduce exception casting?
            throw throwable
        }
    }
}