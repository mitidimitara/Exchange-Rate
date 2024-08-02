package com.mitidimitara.exchangeRate.ui.conversionScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
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
        topBar = { ConversionScreenTopBar() }
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

            Text(text = "from: ${state.fromText}")
            Text(text = "to: ${state.toText}")
            Text(text = "amountForConversion: ${state.amountForConversion}")
            Text(text = "conversionRateNormal: ${state.conversionRateNormal}")
            Text(text = "conversionRateReversed: ${state.conversionRateReversed}")

        }
    }
}