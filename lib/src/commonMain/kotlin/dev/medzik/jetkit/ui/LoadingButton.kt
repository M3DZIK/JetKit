package dev.medzik.jetkit.ui

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun LoadingButton(
    onClick: () -> Unit,
    loading: Boolean,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) = Button(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled && !loading
) {
    if (loading) {
        LoadingIndicator(animating = true)
    } else {
        content()
    }
}

@Composable
fun LoadingButton(
    onClick: suspend () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    LoadingButton(
        onClick = {
            loading = true
            scope.launch(Dispatchers.IO) {
                onClick()
                loading = false
            }
        },
        modifier = modifier,
        loading = loading,
        enabled = enabled,
        content = content
    )
}

@Composable
fun LoadingOutlinedButton(
    onClick: () -> Unit,
    loading: Boolean,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) = OutlinedButton(
    modifier = modifier,
    onClick = onClick,
    enabled = enabled
) {
    if (loading) {
        LoadingIndicator(animating = true)
    } else {
        content()
    }
}

@Composable
fun LoadingOutlinedButton(
    onClick: suspend () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    LoadingOutlinedButton(
        onClick = {
            loading = true
            scope.launch(Dispatchers.IO) {
                onClick()
                loading = false
            }
        },
        modifier = modifier,
        loading = loading,
        enabled = enabled,
        content = content
    )
}

@Composable
private fun LoadingDot(
    color: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(color)
    )
}

@Composable
private fun LoadingIndicator(
    animating: Boolean,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    indicatorSpacing: Dp = 4.dp
) {
    val animatedValues =
        List(3) { index ->
            var animatedValue by remember(animating) { mutableFloatStateOf(0f) }

            LaunchedEffect(animating) {
                if (animating) {
                    animate(
                        initialValue = 8 / 2f,
                        targetValue = -8 / 2f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(durationMillis = 300),
                            repeatMode = RepeatMode.Reverse,
                            initialStartOffset = StartOffset(300 / 3 * index)
                        )
                    ) { value, _ -> animatedValue = value }
                }
            }

            animatedValue
        }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        animatedValues.forEach { animatedValue ->
            LoadingDot(
                modifier = Modifier
                    .padding(horizontal = indicatorSpacing)
                    .width(8.dp)
                    .aspectRatio(1f)
                    .offset(y = animatedValue.dp),
                color = color
            )
        }
    }
}