package com.kirill_nikolaenko.gymbro.ui.navigation.graph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.kirill_nikolaenko.gymbro.ui.navigation.LoginScreen
import com.kirill_nikolaenko.gymbro.ui.navigation.MainPlaceholderScreen
import com.kirill_nikolaenko.gymbro.ui.navigation.RegisterScreen
import com.kirill_nikolaenko.gymbro.ui.navigation.WelcomeScreen
import com.kirill_nikolaenko.gymbro.ui.screen.login.LoginScreen
import com.kirill_nikolaenko.gymbro.ui.screen.register.RegisterScreen
import com.kirill_nikolaenko.gymbro.ui.screen.welcome.WelcomeScreen


fun NavGraphBuilder.authGraph(navController: NavHostController) {
    composable<WelcomeScreen> {
        WelcomeScreen(
            modifier = Modifier,
            onLoginClick = { navController.navigate(LoginScreen) },
            onRegisterClick = { navController.navigate(RegisterScreen) }
        )
    }
    composable<LoginScreen> {
        LoginScreen(
            modifier = Modifier,
            onForgotPasswordClick = {},
            onRegisterClick = { navController.navigate(RegisterScreen) },
            onLoginSuccess = { navController.navigate(MainPlaceholderScreen) },
            onBackPress = { navController.popBackStack() }
        )
    }
    composable<RegisterScreen> {
        RegisterScreen(
            modifier = Modifier,
            onLoginClick = { navController.navigate(LoginScreen) },
            onRegisterSuccess = { navController.navigate(MainPlaceholderScreen) },
            onBackPress = { navController.popBackStack() }
        )
    }
}
