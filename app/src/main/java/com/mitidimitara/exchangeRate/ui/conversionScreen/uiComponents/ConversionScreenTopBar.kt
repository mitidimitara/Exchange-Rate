package com.mitidimitara.exchangeRate.ui.conversionScreen.uiComponents

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.mitidimitara.exchangeRate.ui.theme.LightGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConversionScreenTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Conversion",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarColors(
            containerColor = LightGray,
            scrolledContainerColor = LightGray,
            navigationIconContentColor = Color.White,
            titleContentColor = Color.White,
            actionIconContentColor = Color.White
        )
    )
}