package dev.medzik.jetkit.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.medzik.jetkit.theme.SubtitleAlpha
import dev.medzik.jetkit.theme.combineAlpha

object GroupBoxScope

@Composable
fun GroupBox(
    modifier: Modifier = Modifier,
    content: @Composable GroupBoxScope.() -> Unit
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = MaterialTheme.shapes.large
    ) {
        Box(
            modifier = Modifier.padding(12.dp)
        ) {
            content(GroupBoxScope)
        }
    }
}

@Suppress("UnusedReceiverParameter")
@Composable
fun GroupBoxScope.Title(
    text: String
) = Text(
    text = text,
    style = MaterialTheme.typography.titleMedium
)

@Suppress("UnusedReceiverParameter")
@Composable
fun GroupBoxScope.Subtitle(
    text: String
) = Text(
    text = text,
    color = MaterialTheme.colorScheme.onSurfaceVariant.combineAlpha(SubtitleAlpha),
    style = MaterialTheme.typography.titleSmall
)