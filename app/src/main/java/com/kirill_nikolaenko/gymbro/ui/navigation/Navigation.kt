package com.kirill_nikolaenko.gymbro.ui.navigation
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.kirill_nikolaenko.gymbro.ui.navigation.graph.authGraph
import com.kirill_nikolaenko.gymbro.ui.navigation.graph.mainGraph
import com.kirill_nikolaenko.gymbro.ui.theme.AuthBackground
import com.kirill_nikolaenko.gymbro.ui.utils.SystemBarsConfiguration


@Composable
fun Navigation(navController: NavHostController) {

    val modifier = Modifier
        .fillMaxSize()
        .windowInsetsPadding(WindowInsets.systemBars)

    SystemBarsConfiguration(
        statusBarDarkIcons = true,
        navigationBarDarkIcons = true
    )

    Scaffold(
        modifier = modifier
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = WelcomeScreen,
            modifier = Modifier
                .background(AuthBackground)
                .padding(padding)
        ) {
            authGraph(navController = navController)
            mainGraph()
        }
    }
}