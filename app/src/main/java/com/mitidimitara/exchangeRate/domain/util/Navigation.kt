package com.mitidimitara.exchangeRate.domain.util

import kotlinx.serialization.Serializable

sealed class Screen {

    @Serializable
    data class ChooseCurrency(
        val test: Int = 1
    ) : Screen()

    @Serializable
    data class Conversion(
        val from: Pair<String, Double>,
        val to: Pair<String, Double>,
        val amount: Double
    )
}