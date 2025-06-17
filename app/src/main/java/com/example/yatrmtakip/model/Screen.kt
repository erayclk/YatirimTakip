package com.example.yatrmtakip.model

sealed class Screen (val route:String){
    data object Home:Screen("home_screen")
    data object Login:Screen("login_screen")
    data object SignUp:Screen("signup_screen")
}