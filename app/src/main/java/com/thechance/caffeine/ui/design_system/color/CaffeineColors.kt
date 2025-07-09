package com.thechance.caffeine.ui.design_system.color

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class CaffeineColors(
    val white: Color,
    val beige: Color,
    val brown: Color,
    val darkBrown: Color,
    val black: Color,
)

val LocalCaffeineColor = staticCompositionLocalOf { lightThemeColors }