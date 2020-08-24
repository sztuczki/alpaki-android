package com.example.data.api.interceptors

import com.example.data.api.HEADER_AUTHORIZATION
import com.example.data.api.TOKEN_KEY
import com.example.data.database.SharedPreferenceHandler
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val sharedPreferenceHandler: SharedPreferenceHandler
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val token = sharedPreferenceHandler.getString(TOKEN_KEY)
        request = request.newBuilder()
            .addHeader(
                HEADER_AUTHORIZATION,
                //"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1laWQiOiIxIiwidW5pcXVlX25hbWUiOiIxIiwicm9sZSI6IjciLCJuYmYiOjE1OTc0MjAyNTAsImV4cCI6MTYyODk0OTA1MCwiaWF0IjoxNTk3NDIwMjUwfQ.8s5JNh7gEWGIlOOZpjIl6CV5m2_JWg8AdgzQlCWvr5I"
                "Bearer $token"
            )
            .build()
        return chain.proceed(request)
    }
}