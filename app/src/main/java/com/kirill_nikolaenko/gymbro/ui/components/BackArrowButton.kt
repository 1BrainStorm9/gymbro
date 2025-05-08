package com.kirill_nikolaenko.gymbro.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.kirill_nikolaenko.gymbro.R

/**
 * A reusable back button component with an arrow icon
 * 
 * @param onClick Callback to execute when the button is clicked
 * @param modifier Optional modifier for the button
 */
@Composable
fun BackArrowButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = stringResource(R.string.back)
        )
    }
} 