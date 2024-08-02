package com.mitidimitara.exchangeRate.ui.chooseCurrencyScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.mitidimitara.exchangeRate.domain.util.Screen
import com.mitidimitara.exchangeRate.ui.chooseCurrencyScreen.uiComponents.ChooseCurrencyTopBar
import com.mitidimitara.exchangeRate.ui.chooseCurrencyScreen.uiComponents.CurrencySelector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChooseCurrencyScreen(
    navController: NavController,
    viewModel: ChooseCurrencyViewModel = hiltViewModel()
) {
    val state = viewModel.uiState.collectAsStateWithLifecycle().value
    val snackbarHostState = remember { SnackbarHostState() }

    var amount by remember { mutableStateOf("") }
    var fromCurrency by remember { mutableStateOf(Pair("BGN", 0.0)) }
    var toCurrency by remember { mutableStateOf(Pair("EUR", 0.0)) }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = { ChooseCurrencyTopBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    start = 18.dp,
                    end = 18.dp
                )
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            CurrencySelector(
                "From:",
                fromCurrency.first,
                state.conversionRates.keys.toList()
            ) { selectedCurrency ->
                fromCurrency =
                    Pair(selectedCurrency, state.conversionRates[selectedCurrency] ?: 0.0)
            }

            Spacer(modifier = Modifier.height(8.dp))

            CurrencySelector(
                "To:",
                toCurrency.first,
                state.conversionRates.keys.toList()
            ) { selectedCurrency ->
                toCurrency = Pair(selectedCurrency, state.conversionRates[selectedCurrency] ?: 0.0)
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = amount,
                onValueChange = { amount = it },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                label = { Text("Amount") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                navController.navigate(
                    Screen.Conversion(
                        from = fromCurrency,
                        to = toCurrency,
                        amount = amount.toDouble()
                    )
                )
            }, modifier = Modifier.fillMaxWidth()) {
                Text("Continue")
            }
        }
    }
}