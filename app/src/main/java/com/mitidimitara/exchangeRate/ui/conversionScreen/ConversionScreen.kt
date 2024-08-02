package com.mitidimitara.exchangeRate.ui.conversionScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.mitidimitara.exchangeRate.ui.conversionScreen.uiComponents.ConversionScreenTopBar

@Composable
fun ConversionScreen(
    navController: NavController,
    viewModel: ConversionViewModel = hiltViewModel()
) {
    val state = viewModel.uiState.collectAsStateWithLifecycle().value
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = { ConversionScreenTopBar(onNavigationButtonClicked = { navController.navigateUp() },) }
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
            Spacer(modifier = Modifier.height(24.dp))

            TextField(
                value = state.amountForConversion,
                onValueChange = { viewModel.recalculateConversion(it) },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                label = { Text("Amount") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(18.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                with(state) {
                    Text(
                        text = if (isConversionDirectionChanged) {
                            "$toText to $fromText"
                        } else {
                            "$fromText to $toText"
                        }
                    )
                }

                Switch(
                    checked = state.isConversionDirectionChanged,
                    onCheckedChange = { viewModel.switchConversionDirection() }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            with(state) {
                Text(
                    text = if (isConversionDirectionChanged) {
                        "$amountForConversion $toText equals $conversionRateReversed $fromText"
                    } else {
                        "$amountForConversion $fromText equals $conversionRateNormal $toText"
                    },
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}