package com.kirill_nikolaenko.gymbro.ui.navigation.graph

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kirill_nikolaenko.gymbro.ui.navigation.MainPlaceholderScreen

fun NavGraphBuilder.mainGraph() {
    composable<MainPlaceholderScreen> {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green),
            contentAlignment = Alignment.Center
        ) {
            Text("Main Screen Placeholder", color = Color.White)
        }
    }
}
