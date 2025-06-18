package com.example.yatrmtakip.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yatrmtakip.model.AuthScrenState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

sealed class UiEvent {
    data object Idle : UiEvent()
    data class EnterUsername(val username: String) : UiEvent()
    data class EnterPassword(val password: String) : UiEvent()
    data object SignIn : UiEvent()
    data class ShowSnackbar(val message: String) : UiEvent()
}

class LoginViewModel: ViewModel() {
    private var _state  = MutableStateFlow(AuthScrenState())

    val state: StateFlow<AuthScrenState> = _state.asStateFlow()

    private val _event: Channel<UiEvent> = Channel()
    val event = _event.receiveAsFlow()

    private fun updateEmail(email: String){
        _state.value = _state.value.copy(
            email = email
        )
    }


    private fun updatePassword(password: String){
        _state.value = _state.value.copy(
            password = password
        )
    }
    private fun updateIsLoading(isLoading: Boolean){
        _state.value = _state.value.copy(
            isLoading = isLoading
        )
    }

    fun onEvent(event: UiEvent) {
        when (event) {
            is UiEvent.EnterUsername -> updateEmail(event.username)
            is UiEvent.EnterPassword -> updatePassword(event.password)
            is UiEvent.SignIn ->signIn()
            else -> {}
        }
    }

    fun signIn() {
        viewModelScope.launch {
            updateIsLoading(true)
            delay(2000) // Simulate network delay
            updateIsLoading(false)
            if (_state.value.email == "test" && _state.value.password == "123") {
                _event.send(UiEvent.ShowSnackbar("Login successful"))

            } else {
                _event.send(UiEvent.ShowSnackbar("Invalid Credentials"))
            }
        }
    }




}