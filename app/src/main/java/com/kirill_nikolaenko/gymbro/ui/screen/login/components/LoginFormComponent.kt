package com.kirill_nikolaenko.gymbro.ui.screen.login.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.kirill_nikolaenko.gymbro.R
import com.kirill_nikolaenko.gymbro.ui.screen.login.LoginUiState

@Composable
fun LoginForm(
    uiState: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordVisibilityToggle: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        EmailInput(uiState, onEmailChange)
        PasswordInput(uiState, onPasswordChange, onPasswordVisibilityToggle)
        ForgotPasswordLink(onForgotPasswordClick)
    }
}

@Composable
fun EmailInput(uiState: LoginUiState, onEmailChange: (String) -> Unit) {
    OutlinedTextField(
        value = uiState.email,
        onValueChange = onEmailChange,
        modifier = Modifier.fillMaxWidth(),
        label = { Text(stringResource(R.string.enter_email)) },
        shape = RoundedCornerShape(12.dp),
        singleLine = true,
    )
}

@Composable
fun PasswordInput(
    uiState: LoginUiState,
    onPasswordChange: (String) -> Unit,
    onPasswordVisibilityToggle: () -> Unit
) {
    OutlinedTextField(
        value = uiState.password,
        onValueChange = onPasswordChange,
        modifier = Modifier.fillMaxWidth(),
        label = { Text(stringResource(R.string.enter_password)) },
        shape = RoundedCornerShape(12.dp),
        visualTransformation = if (uiState.passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = onPasswordVisibilityToggle) {
                Icon(
                    imageVector = if (uiState.passwordVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                    contentDescription = if (uiState.passwordVisible) 
                        stringResource(R.string.hide_password) 
                    else 
                        stringResource(R.string.show_password)
                )
            }
        },
        singleLine = true,
    )
}

@Composable
fun ForgotPasswordLink(onForgotPasswordClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = stringResource(R.string.forgot_password),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.clickable(onClick = onForgotPasswordClick),
            color = Color.Gray
        )
    }
} 