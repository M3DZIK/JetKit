package dev.medzik.jetkit.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize

@Composable
fun ExpandedContent(
    expand: Boolean,
    modifier: Modifier = Modifier,
    enter: EnterTransition = fadeIn() + expandIn(
        initialSize = { IntSize(it.width, 0) },
    ),
    exit: ExitTransition = shrinkOut(
        targetSize = { IntSize(it.width, 0) },
    ) + fadeOut(),
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        modifier = modifier,
        visible = expand,
        enter = enter,
        exit = exit,
    ) {
        content()
    }
}

@Composable
fun ExpandedContentRow(
    expand: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) = ExpandedContent(
    expand = expand,
    modifier = modifier,
    enter = fadeIn() + scaleIn() + expandIn(
        initialSize = { IntSize(0, it.height) },
    ),
    exit = shrinkOut(
        targetSize = { IntSize(0, it.height) },
    ) + fadeOut() + scaleOut(),
    content = content
)