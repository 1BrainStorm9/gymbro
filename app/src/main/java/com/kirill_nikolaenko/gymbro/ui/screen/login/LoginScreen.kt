package com.kirill_nikolaenko.gymbro.ui.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kirill_nikolaenko.gymbro.ui.components.BackArrowButton
import com.kirill_nikolaenko.gymbro.ui.screen.login.components.*
import com.kirill_nikolaenko.gymbro.ui.theme.AuthBackground
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onForgotPasswordClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onLoginSuccess: () -> Unit,
    onBackPress: () -> Unit,
    viewModel: LoginViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()


    LaunchedEffect(uiState.isLoggedIn) {
        if (uiState.isLoggedIn) {
            onLoginSuccess()
            viewModel.resetLoginState()
        }
    }

    uiState.errorMessage?.let { error ->
        LaunchedEffect(error) {
            viewModel.clearError()
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AuthBackground)
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start
    ) {
        BackArrowButton(
            onClick = onBackPress,
            modifier = Modifier.offset(x = (-16).dp)
        )

        WelcomeHeader()

        LoginForm(
            uiState = uiState,
            onEmailChange = viewModel::onEmailChange,
            onPasswordChange = viewModel::onPasswordChange,
            onPasswordVisibilityToggle = viewModel::togglePasswordVisibility,
            onForgotPasswordClick = onForgotPasswordClick
        )

        LoginButton(
            onLoginClick = viewModel::loginWithEmail,
            isLoading = uiState.isLoading
        )

        LoginDivider()

        SocialLoginButtons(
            onGoogleClick = viewModel::loginWithGoogle,
            onVkClick = viewModel::loginWithVK,
            onAppleClick = viewModel::loginWithVK
        )

        RegisterPrompt(onRegisterClick)
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        modifier = Modifier,
        onForgotPasswordClick = {},
        onRegisterClick = {},
        onLoginSuccess = {},
        onBackPress = {},
    )
}
