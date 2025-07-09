package com.thechance.caffeine.ui.design_system.device_system

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowInsetsControllerCompat

@Composable
fun UpdateStatusBarIconsForTheme(darkTheme: Boolean = false) {
    val isDarkIcons = !darkTheme
    val view = LocalView.current
    val window = (view.context as? ComponentActivity)?.window ?: return
    WindowInsetsControllerCompat(window, view).apply {
        isAppearanceLightStatusBars = isDarkIcons
    }
}