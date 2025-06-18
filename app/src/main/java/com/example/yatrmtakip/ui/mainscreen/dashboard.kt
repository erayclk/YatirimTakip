package com.example.yatrmtakip.ui.mainscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.yatrmtakip.components.BottomNavigationBar
import com.example.yatrmtakip.model.BottomNavItem
import com.example.yatrmtakip.ui.mainscreen.homescreen.HomeScreen
import com.example.yatrmtakip.ui.mainscreen.profilescren.ProfileScreen
import com.example.yatrmtakip.ui.mainscreen.settingsscreen.SettingsScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashBoard(navController: NavController,) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route
        ) {
            composable(BottomNavItem.Home.route) { HomeScreen() }
            composable(BottomNavItem.Profile.route) { ProfileScreen() }
            composable(BottomNavItem.Settings.route) { SettingsScreen() }
        }
    }
}

