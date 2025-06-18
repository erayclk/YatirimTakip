package com.example.yatrmtakip.model.auth

data class AuthUserState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,

){
}