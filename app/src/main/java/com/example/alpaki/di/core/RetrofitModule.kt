package com.example.alpaki.di.core

import com.example.alpaki.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideOkHttpClient(
        interceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Provides
    fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        if (BuildConfig.DEBUG) level = HttpLoggingInterceptor.Level.BODY
    }
}