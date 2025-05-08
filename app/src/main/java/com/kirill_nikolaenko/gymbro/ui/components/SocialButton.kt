package com.kirill_nikolaenko.gymbro.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kirill_nikolaenko.gymbro.ui.theme.LogButton

/**
 * A reusable social media login button component
 * 
 * @param icon Resource ID for the social media icon
 * @param onClick Callback to execute when the button is clicked
 * @param contentDescription Description for accessibility
 * @param modifier Optional modifier for the button
 */
@Composable
fun SocialButton(
    modifier: Modifier = Modifier,
    icon: Int,
    onClick: () -> Unit,
    contentDescription: String? = null
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        tonalElevation = 2.dp,
        modifier = modifier.size(56.dp).clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = contentDescription,
            contentScale = ContentScale.Fit,
            modifier = Modifier.background(LogButton).padding(16.dp)
        )
    }
} 