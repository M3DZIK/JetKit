package dev.medzik.jetkit.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

internal object CustomShapes {
    val CornerLargeTop = RoundedCornerShape(
        topStart = 16.0.dp,
        topEnd = 16.0.dp,
        bottomEnd = 0.0.dp,
        bottomStart = 0.0.dp
    )

    val CornerLargeBottom = RoundedCornerShape(
        topStart = 0.0.dp,
        topEnd = 0.0.dp,
        bottomEnd = 16.0.dp,
        bottomStart = 16.0.dp
    )
}

@Suppress("UnusedReceiverParameter")
val Shapes.largeTop
    get() = CustomShapes.CornerLargeTop

@Suppress("UnusedReceiverParameter")
val Shapes.largeBottom
    get() = CustomShapes.CornerLargeBottom
