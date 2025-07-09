package com.thechance.caffeine.ui.design_system.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.thechance.caffeine.ui.design_system.color.LocalCaffeineColor
import com.thechance.caffeine.ui.design_system.color.darkThemeColors
import com.thechance.caffeine.ui.design_system.color.lightThemeColors
import com.thechance.caffeine.ui.design_system.device_system.UpdateStatusBarIconsForTheme

@Composable
fun CaffeineTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    UpdateStatusBarIconsForTheme()
    val theme = if (isDarkTheme) darkThemeColors else lightThemeColors
    CompositionLocalProvider(
        LocalCaffeineColor provides theme,
    ) {
        content()
    }
}