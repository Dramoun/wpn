package com.example.wpn.ui.components

import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable

@Composable
fun AppFloatingButton(
  onClick: () -> Unit
) {
  FloatingActionButton(
    onClick = onClick
  ) {
    AppIcon(
      style= AppIconType.ADD.toStyle(),
      onClick = onClick
    )
  }
}