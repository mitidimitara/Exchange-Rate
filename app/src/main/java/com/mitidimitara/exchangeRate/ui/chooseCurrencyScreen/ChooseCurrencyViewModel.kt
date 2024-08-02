package com.mitidimitara.exchangeRate.ui.chooseCurrencyScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.michaelbull.result.fold
import com.mitidimitara.exchangeRate.domain.useCases.GetLatestExchangeRatesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChooseCurrencyViewModel @Inject constructor(
    private val getLatestExchangeRatesUseCase: GetLatestExchangeRatesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ChooseCurrencyState("BGN", emptyMap()))
    val uiState = _uiState.asStateFlow()

    init {
        getLatestExchangeRates()
    }

    private fun getLatestExchangeRates() {
        viewModelScope.launch {
            getLatestExchangeRatesUseCase.invoke("BGN").fold({ response ->
                _uiState.value = _uiState.value.copy(
                    baseCurrency = response.baseRate,
                    conversionRates = response.conversionRates
                )

            }, {
                it
            }
            )
        }
    }
}