package com.example.wpn.ui.components

//TODO: add custom icons and custom icon component
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun AppFloatingButton(
  onClick: () -> Unit
) {
  FloatingActionButton(
    onClick = onClick
  ) {
    Icon(
      imageVector = Icons.Default.Add,
      contentDescription = "Add"
    )
  }
}