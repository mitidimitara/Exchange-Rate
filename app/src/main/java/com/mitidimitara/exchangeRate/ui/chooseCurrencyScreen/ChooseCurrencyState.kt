package com.mitidimitara.exchangeRate.ui.chooseCurrencyScreen

data class ChooseCurrencyState(
    val baseCurrency: String,
    val conversionRates: Map<String, Double>
)