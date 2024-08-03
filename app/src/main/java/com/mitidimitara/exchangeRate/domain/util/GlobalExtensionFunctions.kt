package com.mitidimitara.exchangeRate.domain.util

import androidx.lifecycle.SavedStateHandle
import java.util.Locale

fun SavedStateHandle.getPair(key: String): Pair<String, Double> {
    val value = get<String>(key) ?: return Pair("", 0.0)
    val parts = value.split(",")
    return if (parts.size == 2) {
        Pair(parts[0], parts[1].toDouble())
    } else {
        Pair("", 0.0)
    }
}

fun Double.roundTwoDecimals(): String =
    String.format(Locale.getDefault(), "%.2f", this)

fun String.commasToDots() = replace(",", ".")