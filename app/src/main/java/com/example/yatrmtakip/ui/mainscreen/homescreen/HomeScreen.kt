package com.example.yatrmtakip.ui.mainscreen.homescreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.yatrmtakip.components.TotalBalanceCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(

        floatingActionButton = {
            FloatingActionButton(onClick = { /* Tıklama işlemi */ }) {
                Icon(Icons.Default.Add, contentDescription = "Ekle")
            }
        }
    ) { innerPadding ->
        // İçerik
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(5.dp)
        ) {
            Text("Merhaba, Scaffold!")
            TotalBalanceCard(
                price = 100.0,
                changeAmount = 5.0,
                changePercentage = 5.0,
                status = true
            )
        }
    }
}


@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}

