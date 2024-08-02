package com.mitidimitara.exchangeRate.data.remote.tasks

import com.mitidimitara.exchangeRate.data.remote.ExchangeRateApi
import com.mitidimitara.exchangeRate.data.remote.models.ExchangeRateResponse
import com.mitidimitara.exchangeRate.domain.util.NetworkTask
import retrofit2.Response
import javax.inject.Inject

class GetLatestExchangeRatesTask @Inject constructor(
    private val api: ExchangeRateApi
): NetworkTask<String, ExchangeRateResponse>() {

    override suspend fun provideResponse(params: String): Response<ExchangeRateResponse> {
        return api.getLatestExchangeRates(params)
    }
}