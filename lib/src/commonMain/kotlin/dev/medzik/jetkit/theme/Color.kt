package dev.medzik.jetkit.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

const val NormalAlpha = 1f
const val SubtitleAlpha = 0.6f
const val DisabledComponentAlpha = 0.38f

/**
 * Returns a new [Color] with alpha multiplied by given [alpha] value.
 */
fun Color.combineAlpha(alpha: Float): Color = copy(alpha = this.alpha * alpha)

/**
 * Returns `true` if the background color is dark, `false` otherwise.
 */
val ColorScheme.isDark
    get() = background.luminance() < 0.5f

val ColorScheme.warning: Color
    @Composable
    get() = if (isDark) Color(0xffDBC66E) else Color(0xff6D5E0F) // on #3a3000, #ffffff

val ColorScheme.warningContainer: Color
    @Composable
    get() = if (isDark) Color(0xff534600) else Color(0xffF8E287)

val ColorScheme.onWarningContainer: Color
    @Composable
    get() = if (isDark) Color(0xffF8E287) else Color(0xff221B00)

val ColorScheme.info: Color
    @Composable
    get() = if (isDark) Color(0xffaac7ff) else Color(0xff415f91) // on #0a305f, #ffffff

val ColorScheme.infoContainer: Color
    @Composable
    get() = if (isDark) Color(0xff284777) else Color(0xffd6e3ff)

val ColorScheme.onInfoContainer: Color
    @Composable
    get() = if (isDark) Color(0xffd6e3ff) else Color(0xff001b3e)

val ColorScheme.ok: Color
    @Composable
    get() = if (isDark) Color(0xffa9d0b3) else Color(0xff43664e) // on #143723, #ffffff

val ColorScheme.okContainer: Color
    @Composable
    get() = if (isDark) Color(0xff2c4e38) else Color(0xffc5ecce)

val ColorScheme.onOkContainer: Color
    @Composable
    get() = if (isDark) Color(0xffc5ecce) else Color(0xff00210f)