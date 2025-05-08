package com.kirill_nikolaenko.gymbro.ui.screen.login.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kirill_nikolaenko.gymbro.R
import com.kirill_nikolaenko.gymbro.ui.components.SocialButton

@Composable
fun LoginDivider() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = 1.dp,
            color = Color.Gray
        )
        Text(
            text = "  ${stringResource(R.string.or_login_with)}  ",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = 1.dp,
            color = Color.Gray
        )
    }
}

@Composable
fun SocialLoginButtons(
    onGoogleClick: () -> Unit,
    onVkClick: () -> Unit,
    onAppleClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
    ) {
        SocialButton(
            icon = R.drawable.ic_google, 
            onClick = onGoogleClick,
            contentDescription = stringResource(R.string.login_with_google)
        )
        SocialButton(
            icon = R.drawable.ic_facebook, 
            onClick = onVkClick,
            contentDescription = stringResource(R.string.login_with_vk)
        )
        SocialButton(
            icon = R.drawable.ic_apple, 
            onClick = onAppleClick,
            contentDescription = stringResource(R.string.login_with_apple)
        )
    }
} 