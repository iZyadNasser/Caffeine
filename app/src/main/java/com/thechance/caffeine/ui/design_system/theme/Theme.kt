package com.thechance.caffeine.ui.design_system.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.thechance.caffeine.ui.design_system.color.CaffeineColors
import com.thechance.caffeine.ui.design_system.color.LocalCaffeineColor

object Theme {
    val color: CaffeineColors
        @Composable @ReadOnlyComposable get() = LocalCaffeineColor.current
}