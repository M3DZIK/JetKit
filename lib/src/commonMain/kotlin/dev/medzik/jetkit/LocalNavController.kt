package dev.medzik.jetkit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavController

/**
 * A CompositionLocal that provides a [NavController] instance to child composables.
 * Within its scope. This allows child composables to accession use the
 * [NavController] for navigation.
 *
 * To use this CompositionLocal, you must first provide a NavController instance
 * using the [NavigationProvider] composable.
 */
val LocalNavController = staticCompositionLocalOf<NavController> {
    error("CompositionLocal LocalNavController not present")
}

/**
 * Provides a [NavController] instance to child composables via [LocalNavController].
 *
 * @param navController The NavController instance to provide.
 * @param content The composable content that will have access to the NavController.
 */
@Composable
fun NavigationProvider(
    navController: NavController,
    content: @Composable () -> Unit
) = CompositionLocalProvider(
    LocalNavController provides navController,
    content = content
)