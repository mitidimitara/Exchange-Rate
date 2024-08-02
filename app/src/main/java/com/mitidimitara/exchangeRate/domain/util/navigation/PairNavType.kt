package com.mitidimitara.exchangeRate.domain.util.navigation

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object PairNavType : NavType<Pair<String, Double>>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Pair<String, Double>? {
        val value = bundle.getString(key) ?: return null
        val parts = value.split(",")
        return if (parts.size == 2) {
            Pair(parts[0], parts[1].toDouble())
        } else {
            throw IllegalArgumentException("Invalid Pair format")
        }
    }

    override fun parseValue(value: String): Pair<String, Double> {
        val parts = value.split(",")
        return if (parts.size == 2) {
            Pair(parts[0], parts[1].toDouble())
        } else {
            throw IllegalArgumentException("Invalid Pair format")
        }
    }

    override fun serializeAsValue(value: Pair<String, Double>): String {
        return "${value.first},${value.second}"
    }

    override fun put(bundle: Bundle, key: String, value: Pair<String, Double>) {
        bundle.putString(key, "${value.first},${value.second}")
    }
}