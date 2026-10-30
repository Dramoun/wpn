package com.example.wpn.ui.components

import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun AppFloatingButton(
  onClick: () -> Unit
) {
  FloatingActionButton(
    onClick = onClick,
    containerColor = Color.Transparent
  ) {
    AppIcon(
      style= AppIconType.ADD.toStyle(),
      onClick = onClick
    )
  }
}