package com.mitidimitara.exchangeRate.ui.chooseCurrencyScreen.uiComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencySelector(
    label: String,
    selectedCurrency: String,
    allCurrencies: List<String>,
    onCurrencySelected: (String) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    ExposedDropdownMenuBox(
        modifier = Modifier
            .focusRequester(focusRequester)
            .clickable { isExpanded = true },
        expanded = isExpanded,
        onExpandedChange = { isExpanded = isExpanded.not() }
    ) {
        TextField(
            value = selectedCurrency,
            onValueChange = { },
            label = { Text(label) },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(),
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) }
        )

        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }
        ) {
            Box(modifier = Modifier.size(500.dp)) {
                LazyColumn {
                    items(allCurrencies) { currency ->
                        DropdownMenuItem(
                            text = { Text(text = currency) },
                            onClick = {
                                onCurrencySelected(currency)
                                isExpanded = false // Close dropdown after selection
                            }
                        )
                    }
                }
            }
        }
    }
}