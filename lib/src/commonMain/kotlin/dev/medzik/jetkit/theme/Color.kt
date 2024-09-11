package dev.medzik.jetkit.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.luminance

object Alpha {
    const val Normal = 1f
    const val Subtitle = 0.6f
    const val DisabledComponent = 0.38f
}

/**
 * Returns a new [Color] with alpha multiplied by given [alpha] value.
 *
 * @param alpha the alpha value to multiple by.
 * @return A new [Color] with alpha multiplied by given [alpha] value.
 */
fun Color.combineAlpha(alpha: Float): Color = copy(alpha = this.alpha * alpha)

/**
 * Returns `true` if the background color is dark, `false` otherwise.
 */
val ColorScheme.isDark
    get() = background.luminance() < 0.5f

private object Hue {
    const val WARNING = 55f
    const val INFO = 210f
    const val OK = 120f
}

val ColorScheme.warning: Color
    @Composable
    get() = buildContentColor(Hue.WARNING)

val ColorScheme.info: Color
    @Composable
    get() = buildContentColor(Hue.INFO)

val ColorScheme.ok: Color
    @Composable
    get() = buildContentColor(Hue.OK)

@Composable
private fun ColorScheme.buildContentColor(
    hue: Float,
): Color {
    val isDark = isDark
    val color = remember(isDark) {
        buildContentColor(
            hue = hue,
            onDark = isDark,
        )
    }
    return color
}

private fun buildContentColor(
    hue: Float,
    onDark: Boolean,
): Color {
    val saturation: Float
    val lightness: Float
    if (onDark) {
        saturation = 0.72f // saturation
        lightness = 0.86f // value
    } else {
        saturation = 0.96f // saturation
        lightness = 0.80f // value
    }
    return Color.hsv(
        hue = hue,
        saturation = saturation,
        value = lightness,
    )
}

val ColorScheme.warningContainer: Color
    @Composable
    get() = buildContainerColor(Hue.WARNING)

val ColorScheme.onWarningContainer: Color
    @Composable
    get() = buildOnContainerColor(Hue.WARNING)

val ColorScheme.infoContainer: Color
    @Composable
    get() = buildContainerColor(Hue.INFO)

val ColorScheme.onInfoContainer: Color
    @Composable
    get() = buildOnContainerColor(Hue.INFO)

val ColorScheme.okContainer: Color
    @Composable
    get() = buildContainerColor(Hue.OK)

val ColorScheme.onOkContainer: Color
    @Composable
    get() = buildOnContainerColor(Hue.OK)

@Composable
private fun ColorScheme.buildContainerColor(
    hue: Float,
): Color {
    val tint = Color.hsv(
        hue = hue,
        saturation = 1f,
        value = 1f,
    )
    val backgroundColor = if (isDark) {
        surfaceVariant
    } else {
        surfaceVariant
    }
    return tint
        .copy(alpha = 0.20f)
        .compositeOver(backgroundColor)
}

@Composable
private fun ColorScheme.buildOnContainerColor(
    hue: Float,
): Color {
    val isDark = isDark
    val color = remember(isDark) {
        buildOnContainerColor(
            hue = hue,
            onDark = isDark,
        )
    }
    return color
}

private fun buildOnContainerColor(
    hue: Float,
    onDark: Boolean,
): Color {
    val saturation: Float
    val lightness: Float
    if (onDark) {
        saturation = 0.1f // saturation
        lightness = 0.9f // value
    } else {
        saturation = 0.2f // saturation
        lightness = 0.2f // value
    }
    return Color.hsv(
        hue = hue,
        saturation = saturation,
        value = lightness,
    )
}