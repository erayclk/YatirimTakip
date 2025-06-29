package com.example.yatrmtakip.ui.mainscreen.homescreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.yatrmtakip.components.CategoryCard
import com.example.yatrmtakip.components.TotalBalanceCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var isFabExpanded by remember { mutableStateOf(false) }

    Scaffold(

        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            Box(modifier = Modifier.padding(bottom = 70.dp)) { // FAB'i BottomBar'ın üstüne al

                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    AnimatedVisibility(visible = isFabExpanded) {
                        SmallFloatingActionButton(
                            onClick = { /* 1. işlem */ },
                            containerColor = Color.Gray
                        ) {
                            Icon(Icons.Default.Email, contentDescription = "Email")
                        }
                    }

                    AnimatedVisibility(visible = isFabExpanded) {
                        SmallFloatingActionButton(
                            onClick = { /* 2. işlem */ },
                            containerColor = Color.Gray
                        ) {
                            Icon(Icons.Default.Phone, contentDescription = "Phone")
                        }
                    }

                    AnimatedVisibility(visible = isFabExpanded) {
                        SmallFloatingActionButton(
                            onClick = { /* 3. işlem */ },
                            containerColor = Color.Gray
                        ) {
                            Icon(Icons.Default.Share, contentDescription = "Share")
                        }
                    }

                    AnimatedVisibility(visible = isFabExpanded) {
                        SmallFloatingActionButton(
                            onClick = { /* 4. işlem */ },
                            containerColor = Color.Gray
                        ) {

                            Icon(Icons.Default.Settings, contentDescription = "Settings")

                        }
                    }

                    // Ana FAB
                    FloatingActionButton(
                        onClick = { isFabExpanded = !isFabExpanded },
                        containerColor = Color.DarkGray,
                        elevation = FloatingActionButtonDefaults.elevation(
                            defaultElevation = 8.dp,
                            pressedElevation = 12.dp,
                            focusedElevation = 10.dp,
                            hoveredElevation = 10.dp
                        )


                    ) {
                        Icon(
                            imageVector = if (isFabExpanded) Icons.Default.Close else Icons.Default.Add,
                            contentDescription = "Toggle FAB"
                        )
                    }
                }
            }
        },

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(25.dp)
        ) {
            Text("Merhaba, Scaffold!")
            Spacer(modifier = Modifier.padding(10.dp))
            TotalBalanceCard(
                price = 100.0,
                changeAmount = 5.0,
                changePercentage = 5.0,
                status = true
            )
            Spacer(modifier = Modifier.padding(10.dp))
            repeat(4) {
                CategoryCard()
                Spacer(modifier = Modifier.padding(10.dp))
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}

