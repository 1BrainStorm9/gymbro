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
import androidx.navigation.compose.composable
import com.kirill_nikolaenko.gymbro.ui.screen.login.LoginScreen
import com.kirill_nikolaenko.gymbro.ui.screen.register.RegisterScreen
import com.kirill_nikolaenko.gymbro.ui.screen.welcome.WelcomeScreen
import com.kirill_nikolaenko.gymbro.ui.theme.AuthBackground
import com.kirill_nikolaenko.gymbro.ui.utils.SystemBarsConfiguration


object Navigator {
    const val WELCOME = "welcome_screen"
    const val LOGIN = "login_screen"
    const val REGISTER = "register_screen"
}

@Composable
fun Navigation(
    navController: NavHostController,
) {

    val modifier = Modifier
        .fillMaxSize()
        .windowInsetsPadding(WindowInsets.systemBars)

    SystemBarsConfiguration(
        statusBarDarkIcons = true,
        navigationBarDarkIcons = true
    )

    Scaffold (
        modifier = modifier
    ){ paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Navigator.WELCOME,
            modifier = Modifier
                .background(AuthBackground)
                .then(Modifier.padding(paddingValues))
        ) {
            composable(Navigator.WELCOME) {
                WelcomeScreen(
                    modifier = modifier,
                    onLoginClick = { navController.navigate(Navigator.LOGIN) },
                    onRegisterClick = {navController.navigate(Navigator.REGISTER)}
                )
            }
            composable(Navigator.LOGIN) {
                LoginScreen(
                    modifier = modifier,
                    onForgotPasswordClick = {},
                    onRegisterClick = {navController.navigate(Navigator.REGISTER)},
                    onLoginSuccess = {},
                    onBackPress = {navController.popBackStack()}
                )
            }
            composable(Navigator.REGISTER) {
                RegisterScreen(
                    modifier = modifier,
                    onLoginClick = {navController.navigate(Navigator.LOGIN)},
                    onRegisterSuccess = {},
                    onBackPress = {navController.popBackStack()}
                )
            }
        }
    }
}
