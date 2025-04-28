package com.kirill_nikolaenko.gymbro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.kirill_nikolaenko.gymbro.ui.navigation.Navigation
import com.kirill_nikolaenko.gymbro.ui.theme.GymbroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            GymbroTheme {
                Navigation(
                    navController
                )
            }
        }
    }
}
