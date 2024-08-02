package com.mitidimitara.exchangeRate.ui.conversionScreen

data class ConversionState(
    val toText: String,
    val fromText: String,
    val amountForConversion: String,
    val conversionRateNormal: String,
    val conversionRateReversed: String,
    val isConversionDirectionChanged: Boolean = false
) {
    companion object {
        const val KEY_TO_CURRENCY = "to"
        const val KEY_FROM_CURRENCY = "from"
        const val KEY_AMOUNT = "amount"
    }
}