package com.example.yatrmtakip.ui.login

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.yatrmtakip.model.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = viewModel()
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.state.collectAsStateWithLifecycle()


    val event by viewModel.event.collectAsStateWithLifecycle(initialValue = UiEvent.Idle)
    val snackbarHostState = remember { SnackbarHostState() }




    LaunchedEffect(event) {
        when (event) {
            is UiEvent.ShowSnackbar -> {
                snackbarHostState.showSnackbar((event as UiEvent.ShowSnackbar).message)
            }

            else -> {}
        }
    }
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "Yatırım Takip",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                )
            })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start

        ) {
            Row {
                Text(
                    text = "Giriş Yap", style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.padding(15.dp))
                VerticalDivider(
                    modifier = Modifier.height(20.dp),
                    thickness = 2.dp
                )
                Spacer(modifier = Modifier.padding(15.dp))
                Text(text = "Kayıt Oluştur",
                    modifier = Modifier.clickable {
                        navController.navigate(Screen.SignUp.route)
                    }
                )
            }
            OutlinedTextField(
                value = state.email,
                onValueChange = { email ->
                    viewModel.onEvent(UiEvent.EnterUsername(email))
                },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = state.password,
                onValueChange = { password ->
                    viewModel.onEvent(UiEvent.EnterPassword(password))
                },
                label = { Text("Şifre") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(15.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.signIn()
                    navController.navigate(Screen.Main.route)
                },
                enabled = !state.isLoading
            ) {
                AnimatedContent(targetState = state.isLoading) {
                    if (it) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp),
                            strokeWidth = 2.dp
                        )
                    } else {
                        Text(text = "Sign In")
                    }
                }
            }


        }

    }

}

@Composable
@Preview(showBackground = true)
fun preViewLoginScreen() {
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}
