package com.example.yatrmtakip.model.auth

data class AuthScrenState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false
)