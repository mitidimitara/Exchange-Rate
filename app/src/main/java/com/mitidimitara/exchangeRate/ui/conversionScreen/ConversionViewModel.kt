package com.mitidimitara.exchangeRate.ui.conversionScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mitidimitara.exchangeRate.domain.util.getPair
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ConversionViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val toCurrency: Pair<String, Double> = savedStateHandle.getPair(ConversionState.KEY_TO_CURRENCY)
    val fromCurrency: Pair<String, Double> = savedStateHandle.getPair(ConversionState.KEY_FROM_CURRENCY)
    val amountForConversion: Double = (savedStateHandle.get<String>(ConversionState.KEY_AMOUNT)?.toDouble()) ?: 0.0

    val conversionRateNormal = (toCurrency.second / fromCurrency.second) * amountForConversion
    val conversionRateReversed = (fromCurrency.second / toCurrency.second) * amountForConversion

    private val _uiState = MutableStateFlow<ConversionState>(getConversionData())
    val uiState = _uiState.asStateFlow()

    private fun getConversionData(): ConversionState {
        return ConversionState(
            toText = toCurrency.first,
            fromText = fromCurrency.first,
            amountForConversion = amountForConversion.toString(),
            conversionRateNormal = conversionRateNormal.toString(),
            conversionRateReversed = conversionRateReversed.toString()
        )
    }
}