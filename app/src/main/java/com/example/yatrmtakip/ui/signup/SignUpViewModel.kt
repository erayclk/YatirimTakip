package com.example.yatrmtakip.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yatrmtakip.model.AuthUserState
import com.example.yatrmtakip.ui.login.UiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

sealed class UiSignUpEvent {
    data object Idle : UiSignUpEvent()
    data class EnterUsername(val username: String) : UiSignUpEvent()
    data class EnterPassword(val password: String) : UiSignUpEvent()
    data class EnterEmail(val email: String) : UiSignUpEvent()
    data object RegisterUser : UiSignUpEvent()
    data class ShowSnackbar(val message: String) : UiSignUpEvent()
}

class SignUpViewModel : ViewModel() {
    private var _state = MutableStateFlow(AuthUserState())
    val state: StateFlow<AuthUserState> = _state.asStateFlow()

    private val _event: Channel<UiSignUpEvent> = Channel()
    val event = _event.receiveAsFlow()

    fun updateName(name: String) {
        _state.value = _state.value.copy(
            name = name
        )
    }


    private fun updateEmail(email: String) {
        _state.value = _state.value.copy(
            email = email
        )
    }

    private fun updatePassword(password: String) {
        _state.value = _state.value.copy(
            password = password
        )
    }

    private fun updateIsLoading(isLoading: Boolean) {
        _state.value = _state.value.copy(
            isLoading = isLoading
        )
    }

    fun onEvent(event: UiSignUpEvent) {
        when (event) {
            is UiSignUpEvent.EnterUsername -> {
                updateEmail(event.username)
            }

            is UiSignUpEvent.EnterPassword -> {
                updatePassword(event.password)
            }

            is UiSignUpEvent.EnterEmail -> {
                updateEmail(event.email)
            }

            is UiSignUpEvent.RegisterUser -> {
                registerUser()
            }


            else -> {}
        }
    }

    fun registerUser() {
        viewModelScope.launch {
            updateIsLoading(true)
            delay(2000) // Simulate network delay
            updateIsLoading(false)
            if (_state.value.email == "test" && _state.value.password == "123") {
                _event.send(UiSignUpEvent.ShowSnackbar("Login successful"))
            } else {
                _event.send(UiSignUpEvent.ShowSnackbar("Invalid Credentials"))
            }
        }
    }


}