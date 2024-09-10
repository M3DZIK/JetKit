package dev.medzik.jetkit.theme

import androidx.compose.ui.graphics.Color

fun Color.combineAlpha(alpha: Float): Color = copy(alpha = this.alpha * alpha)