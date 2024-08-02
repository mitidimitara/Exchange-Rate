package com.mitidimitara.exchangeRate.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mitidimitara.exchangeRate.data.remote.ExchangeRateApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val API_KEY = "6e6aab3457700917e567e1e0"
    private const val BASE_URL = "https://v6.exchangerate-api.com/v6/${API_KEY}/"
    private const val CONTENT_TYPE = "application/json"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json { ignoreUnknownKeys = true }.asConverterFactory(CONTENT_TYPE.toMediaType()))
            .build()

    @Provides
    @Singleton
    fun provideExchangeRateApi(retrofit: Retrofit): ExchangeRateApi =
        retrofit.create(ExchangeRateApi::class.java)
}