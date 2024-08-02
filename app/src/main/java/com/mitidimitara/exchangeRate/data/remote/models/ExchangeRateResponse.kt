package com.mitidimitara.exchangeRate.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExchangeRateResponse(
    @SerialName("time_last_update_unix")
    val lastUpdateUnixTimestamp: Long,
    @SerialName("time_next_update_unix")
    val nextUpdateUnixTimestamp: Long,
    @SerialName("base_code")
    val baseRate: String,
    @SerialName("conversion_rates")
    val conversionRates: Map<String, Double>
)