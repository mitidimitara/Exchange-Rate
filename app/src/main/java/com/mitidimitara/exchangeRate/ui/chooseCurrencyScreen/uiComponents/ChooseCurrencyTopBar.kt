package com.mitidimitara.exchangeRate.ui.chooseCurrencyScreen.uiComponents

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun ChooseCurrencyTopBar(

) {
    TopAppBar(
        title = {
            Text(
                text = "Choose Currency",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        },
        actions = {
//            IconButton(onClick = onFilterNotesClicked) {
//                Icon(
//                    imageVector = Icons.Default.FilterList,
//                    contentDescription = "Filter notes list."
//                )
//            }
//            IconButton(onClick = onAddNoteClicked) {
//                Icon(
//                    imageVector = Icons.Default.Add,
//                    contentDescription = "Add new note."
//                )
//            }
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