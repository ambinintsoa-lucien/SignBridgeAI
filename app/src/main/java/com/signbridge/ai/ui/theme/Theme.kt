package com.signbridge.ai.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = BluePrimary,
    onPrimary = White,
    primaryContainer = BlueLight,
    onPrimaryContainer = GrayDark,
    secondary = GreenSuccess,
    onSecondary = White,
    error = RedAlert,
    onError = White,
    background = BackgroundSoft,
    onBackground = GrayDark,
    surface = White,
    onSurface = GrayDark,
    surfaceVariant = GrayLight,
    onSurfaceVariant = GrayMedium
)

@Composable
fun SignBridgeTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = SignBridgeTypography,
        content = content
    )
}
