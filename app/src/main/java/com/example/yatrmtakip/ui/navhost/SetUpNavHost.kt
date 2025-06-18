package com.example.yatrmtakip.ui.navhost

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yatrmtakip.model.Screen
import com.example.yatrmtakip.ui.login.LoginScreen
import com.example.yatrmtakip.ui.mainscreen.DashBoard
import com.example.yatrmtakip.ui.signup.SignUpScreen

@Composable
fun SetUpNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController,
        startDestination = Screen.Main.route
    ) {

        composable(
            Screen.Login.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            },
        ) {
            LoginScreen(navController)

        }
        composable(Screen.SignUp.route) {
            SignUpScreen(navController)
        }
        composable(Screen.Main.route) {
            DashBoard(navController)
        }


    }

}