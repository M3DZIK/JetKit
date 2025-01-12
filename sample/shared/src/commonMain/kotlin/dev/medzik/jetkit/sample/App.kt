package dev.medzik.jetkit.sample

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.medzik.jetkit.sample.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        Scaffold { innerPadding ->
            val navController = rememberNavController()

            NavHost(
                navController,
                startDestination = "home"
            ) {
                composable("home") {
                    HomePage(innerPadding)
                }
            }
        }
    }
}
