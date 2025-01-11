package dev.medzik.jetkit.sample

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import dev.medzik.jetkit.sample.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        Scaffold { innerPadding ->
            // crashing
            // FATAL EXCEPTION: main
            //  Process: com.myapplication.MyApplication, PID: 6502
            //  kotlinx.serialization.SerializationException: Serializer for class 'ComposableSingletons$AppKt$lambda-1$1$$ExternalSyntheticLambda0' is not found.
            //  Please ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.
//            val navController = rememberNavController()
//
//            NavHost(
//                navController,
//                startDestination = { "home" }
//            ) {
//                composable("home") {
////                    HomePage(innerPadding)
//                }
//            }

            HomePage(innerPadding)
        }
    }
}
