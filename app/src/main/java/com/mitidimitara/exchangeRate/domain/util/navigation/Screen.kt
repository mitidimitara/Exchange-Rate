package com.mitidimitara.exchangeRate.domain.util.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

sealed class Screen {

    @Serializable
    data class ChooseCurrency(
        val test: Int = 1
    ) : Screen()

    @Serializable
    @Parcelize
    data class Conversion(
        val from: Pair<String, Double>,
        val to: Pair<String, Double>,
        val amount: String
    ): Parcelable
}