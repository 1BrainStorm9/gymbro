package com.kirill_nikolaenko.gymbro.ui.screen.login.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kirill_nikolaenko.gymbro.R
import com.kirill_nikolaenko.gymbro.ui.screen.login.LoginUiState
import com.kirill_nikolaenko.gymbro.ui.theme.AuthBackground
import com.kirill_nikolaenko.gymbro.ui.theme.green

@Composable
fun LoginButton(
    onLoginClick: () -> Unit,
    isLoading: Boolean
) {
    Button(
        onClick = onLoginClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = green,
            contentColor = AuthBackground
        ),
        enabled = !isLoading
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(24.dp),
                color = AuthBackground,
                strokeWidth = 2.dp
            )
        } else {
            Text(stringResource(R.string.login), style = MaterialTheme.typography.bodyLarge)
        }
    }
} 