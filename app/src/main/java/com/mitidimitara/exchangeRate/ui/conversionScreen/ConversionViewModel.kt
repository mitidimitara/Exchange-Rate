package com.mitidimitara.exchangeRate.ui.conversionScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mitidimitara.exchangeRate.domain.util.getPair
import com.mitidimitara.exchangeRate.domain.util.roundTwoDecimals
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ConversionViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val toCurrency: Pair<String, Double> = savedStateHandle.getPair(ConversionState.KEY_TO_CURRENCY)
    private val fromCurrency: Pair<String, Double> = savedStateHandle.getPair(ConversionState.KEY_FROM_CURRENCY)
    private val amountForConversion: Double = (savedStateHandle.get<String>(ConversionState.KEY_AMOUNT)?.toDouble()) ?: 0.0

    private val conversionRateNormal = (toCurrency.second / fromCurrency.second) * amountForConversion
    private val conversionRateReversed = (fromCurrency.second / toCurrency.second) * amountForConversion

    private val _uiState = MutableStateFlow(
        ConversionState(
            toText = toCurrency.first,
            fromText = fromCurrency.first,
            amountForConversion = amountForConversion.toString(),
            conversionRateNormal = conversionRateNormal.roundTwoDecimals(),
            conversionRateReversed = conversionRateReversed.roundTwoDecimals()
        )
    )
    val uiState = _uiState.asStateFlow()

    fun switchConversionDirection() {
        val oldValue = _uiState.value.isConversionDirectionChanged

        _uiState.value = _uiState.value.copy(
            isConversionDirectionChanged = oldValue.not()
        )
    }

    fun recalculateConversion(amount: String) {
        val conversionRateNormal = (toCurrency.second / fromCurrency.second) * amount.toDouble()
        val conversionRateReversed = (fromCurrency.second / toCurrency.second) * amount.toDouble()

        _uiState.value = _uiState.value.copy(
            amountForConversion = amount,
            conversionRateNormal = conversionRateNormal.roundTwoDecimals(),
            conversionRateReversed = conversionRateReversed.roundTwoDecimals()
        )
    }
}