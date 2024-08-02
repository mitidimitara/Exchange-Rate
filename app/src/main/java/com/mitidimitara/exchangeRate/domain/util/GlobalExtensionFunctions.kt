package com.mitidimitara.exchangeRate.domain.util

import androidx.lifecycle.SavedStateHandle

fun SavedStateHandle.getPair(key: String): Pair<String, Double> {
    val value = get<String>(key) ?: return Pair("", 0.0)
    val parts = value.split(",")
    return if (parts.size == 2) {
        Pair(parts[0], parts[1].toDouble())
    } else {
        Pair("", 0.0)
    }
}