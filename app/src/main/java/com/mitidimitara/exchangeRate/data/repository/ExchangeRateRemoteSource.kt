package com.mitidimitara.exchangeRate.data.repository

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.fold
import com.mitidimitara.exchangeRate.data.remote.models.ExchangeRateResponse
import com.mitidimitara.exchangeRate.data.remote.tasks.GetLatestExchangeRatesTask
import javax.inject.Inject

class ExchangeRateRemoteSource @Inject constructor(
    private val getLatestExchangeRatesTask: GetLatestExchangeRatesTask
) : ExchangeRateRepository.RemoteSource {

    override suspend fun getLatestExchangeRates(baseCurrency: String): Result<ExchangeRateResponse, Exception> {
        return getLatestExchangeRatesTask.execute(baseCurrency).fold({
            Ok(it)
        }, {
            Err(it)
        })
    }
}