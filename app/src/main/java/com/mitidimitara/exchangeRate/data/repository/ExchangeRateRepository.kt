package com.mitidimitara.exchangeRate.data.repository

import com.github.michaelbull.result.Result
import com.mitidimitara.exchangeRate.data.remote.models.ExchangeRateResponse
import javax.inject.Inject

class ExchangeRateRepository @Inject constructor(
    private val remoteSource: ExchangeRateRemoteSource
) {

    suspend fun getLatestExchangeRates(baseCurrency: String) =
        remoteSource.getLatestExchangeRates(baseCurrency)

    interface RemoteSource {
        suspend fun getLatestExchangeRates(baseCurrency: String): Result<ExchangeRateResponse, Exception>
    }

}