package com.example.wpn.ui.theme

import androidx.compose.ui.graphics.Color

// ============================================================
// Light theme
// ============================================================

val LightPrimary = Color(0xFF1F1F1F)
val LightOnPrimary = Color(0xFFFFFFFF)

val LightSecondary = Color(0xFF5A5A5A)
val LightOnSecondary = Color(0xFFFFFFFF)

val LightTertiary = Color(0xFF757575)
val LightOnTertiary = Color(0xFFFFFFFF)

val LightBackground = Color(0xFFFFFFFF)
val LightOnBackground = Color(0xFF1C1C1C)

val LightSurface = Color(0xFFFFFFFF)
val LightOnSurface = Color(0xFF1C1C1C)

val LightSurfaceVariant = Color(0xFFE9E9E9)
val LightOnSurfaceVariant = Color(0xFF4A4A4A)

val LightError = Color(0xFFBA1A1A)
val LightOnError = Color(0xFFFFFFFF)


// ============================================================
// Dark theme
// ============================================================
//
// Based on the previous app's dark palette:
//
// Background       #0F172A
// Surface          #1E293B
// SurfaceVariant   #334155
// TextPrimary      #FFFFFF
// TextSecondary    #94A3B8
//
// The primary colors remain neutral so the default theme does
// not impose a neon/accent color on the entire application.
// ============================================================

val DarkPrimary = Color(0xFFFFFFFF)
val DarkOnPrimary = Color(0xFF1E293B)

val DarkSecondary = Color(0xFF94A3B8)
val DarkOnSecondary = Color(0xFF0F172A)

val DarkTertiary = Color(0xFFCBD5E1)
val DarkOnTertiary = Color(0xFF0F172A)

val DarkBackground = Color(0xFF0F172A)
val DarkOnBackground = Color(0xFFFFFFFF)

val DarkSurface = Color(0xFF1E293B)
val DarkOnSurface = Color(0xFFFFFFFF)

val DarkSurfaceVariant = Color(0xFF334155)
val DarkOnSurfaceVariant = Color(0xFFCBD5E1)

val DarkError = Color(0xFFF87171)
val DarkOnError = Color(0xFF450A0A)


// ============================================================
// App-specific semantic colors
// ============================================================
//
// These are NOT part of the default neutral theme.
// They are used when a component intentionally wants a
// semantic/accent color.
// ============================================================

val SuccessColor = Color(0xFF4ADE80)
val ExpenseColor = Color(0xFFF87171)

val HousingColor = Color(0xFF60A5FA)
val FoodColor = Color(0xFF60A5FA)
val TransportColor = Color(0xFF60A5FA)

val SportsColor = Color(0xFFFB923C)
val GamingColor = Color(0xFFFB923C)

val SubscriptionColor = Color(0xFFF87171)
val SavingsColor = Color(0xFFC084FC)

val AlarmColor = Color(0xFFFBBF24)
val FavoriteColor = Color(0xFFFB7185)
val ExtensionColor = Color(0xFF2DD4BF)

val LetterColor = Color(0xFF818CF8)


// ============================================================
// Semantic background washes
// ============================================================
//
// These are deliberately kept separate so cards/info surfaces
// can use low-opacity versions of semantic colors.
// ============================================================

val SuccessBackground = Color(0x264ADE80)
val ExpenseBackground = Color(0x26F87171)

val BlueBackground = Color(0x2660A5FA)
val OrangeBackground = Color(0x26FB923C)
val PurpleBackground = Color(0x26C084FC)
val NeutralBackground = Color(0x26888888)
val CyanBackground = Color(0x2622D3EE)
val PinkBackground = Color(0x26F472B6)