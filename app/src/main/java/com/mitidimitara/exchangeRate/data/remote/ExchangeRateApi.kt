package com.mitidimitara.exchangeRate.data.remote

import com.mitidimitara.exchangeRate.data.remote.models.ExchangeRateResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ExchangeRateApi {

    @GET("latest/{baseCurrency}")
    suspend fun getLatestExchangeRates(
        @Path("baseCurrency") baseCurrency: String
    ): Response<ExchangeRateResponse>
}