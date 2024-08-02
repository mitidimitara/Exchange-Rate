package com.mitidimitara.exchangeRate.domain.useCases

import com.github.michaelbull.result.Result
import com.mitidimitara.exchangeRate.data.remote.models.ExchangeRateResponse
import com.mitidimitara.exchangeRate.data.repository.ExchangeRateRepository
import com.mitidimitara.exchangeRate.domain.util.BaseUseCase.UseCase
import javax.inject.Inject

class GetLatestExchangeRatesUseCase @Inject constructor(
    private val exchangeRateRepository: ExchangeRateRepository
) : UseCase<String, ExchangeRateResponse>() {

    override suspend fun execute(input: String): Result<ExchangeRateResponse, Exception> =
        exchangeRateRepository.getLatestExchangeRates(input)

}