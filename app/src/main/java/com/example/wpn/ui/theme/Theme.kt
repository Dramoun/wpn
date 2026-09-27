package com.example.wpn.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
  primary = LightPrimary,
  onPrimary = LightOnPrimary,

  secondary = LightSecondary,
  onSecondary = LightOnSecondary,

  background = LightBackground,
  onBackground = LightOnBackground,

  surface = LightSurface,
  onSurface = LightOnSurface,

  error = LightError,
  onError = LightOnError
)

private val DarkColorScheme = darkColorScheme(
  primary = DarkPrimary,
  onPrimary = DarkOnPrimary,

  secondary = DarkSecondary,
  onSecondary = DarkOnSecondary,

  background = DarkBackground,
  onBackground = DarkOnBackground,

  surface = DarkSurface,
  onSurface = DarkOnSurface,

  error = DarkError,
  onError = DarkOnError
)

@Composable
fun AppTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit
) {
  val colorScheme = if (darkTheme) {
    DarkColorScheme
  } else {
    LightColorScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}