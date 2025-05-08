package com.kirill_nikolaenko.gymbro.ui.screen.login.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.kirill_nikolaenko.gymbro.R
import com.kirill_nikolaenko.gymbro.ui.theme.green

@Composable
fun RegisterPrompt(onRegisterClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            buildAnnotatedString {
                append(stringResource(R.string.dont_have_account))
                append(" ")
                withStyle(SpanStyle(color = green, fontWeight = FontWeight.Bold)) {
                    append(stringResource(R.string.register_now))
                }
            },
            modifier = Modifier.clickable(onClick = onRegisterClick),
            style = MaterialTheme.typography.bodySmall
        )
    }
} 