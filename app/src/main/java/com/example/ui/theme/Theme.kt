package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

private val DarkColorScheme = darkColorScheme(
    primary = SapphirePrimaryDark,
    onPrimary = OnSapphireDark,
    primaryContainer = SapphireContainerDark,
    onPrimaryContainer = OnSapphireContainerDark,
    secondary = PitambaraGoldDark,
    onSecondary = OnPitambaraGoldDark,
    secondaryContainer = PitambaraContainerDark,
    onSecondaryContainer = OnPitambaraContainerDark,
    tertiary = LotusRoseDark,
    tertiaryContainer = LotusContainerDark,
    background = MidnightBackground,
    onBackground = LightInk,
    surface = MidnightSurface,
    onSurface = LightInk,
    surfaceVariant = MidnightSurfaceVariant,
    onSurfaceVariant = MutedLightInk,
    outline = DarkGoldBorder,
    error = EmergencyCrimsonBright
)

private val LightColorScheme = lightColorScheme(
    primary = SapphirePrimaryLight,
    onPrimary = OnSapphireLight,
    primaryContainer = SapphireContainerLight,
    onPrimaryContainer = OnSapphireContainerLight,
    secondary = PitambaraGoldLight,
    onSecondary = OnPitambaraGoldLight,
    secondaryContainer = PitambaraContainerLight,
    onSecondaryContainer = OnPitambaraContainerLight,
    tertiary = LotusRoseLight,
    tertiaryContainer = LotusContainerLight,
    background = SandIvoryBackground,
    onBackground = InkDark,
    surface = WarmParchmentSurface,
    onSurface = InkDark,
    surfaceVariant = WarmSurfaceVariant,
    onSurfaceVariant = MutedInk,
    outline = SubtleGoldBorder,
    error = EmergencyCrimson
)

val AppShapes = Shapes(
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(18.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(30.dp)
)

@Composable
fun VishnuRakshaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}
