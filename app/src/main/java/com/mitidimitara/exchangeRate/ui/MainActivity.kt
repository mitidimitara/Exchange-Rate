package com.mitidimitara.exchangeRate.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mitidimitara.exchangeRate.domain.util.Screen
import com.mitidimitara.exchangeRate.ui.chooseCurrencyScreen.ChooseCurrencyScreen
import com.mitidimitara.exchangeRate.ui.theme.ExchangeRateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initEdgeToEdge()

        setContent {
            ExchangeRateTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.ChooseCurrency::class
                    ) {
                        composable<Screen.ChooseCurrency> { ChooseCurrencyScreen(navController) }
                    }
                }
            }
        }
    }

    private fun initEdgeToEdge() {
        val transparentColor = Color.Transparent.toArgb()
        actionBar?.hide()

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                transparentColor
            ),
            navigationBarStyle = SystemBarStyle.light(
                transparentColor,
                transparentColor
            )
        )
    }
}