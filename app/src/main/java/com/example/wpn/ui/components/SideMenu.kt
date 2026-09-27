package com.example.wpn.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SideMenu(
  onDismiss: () -> Unit
) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(
        MaterialTheme.colorScheme.background
      )
  ) {

    // Menu
    Column(
      modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(0.4f)
        .background(MaterialTheme.colorScheme.surface)
        .padding(16.dp)
    ) {

      // TODO: add custom title components of different sizes
      Text(
        text = "Menu",
        style = MaterialTheme.typography.titleLarge
      )

      Spacer(
        modifier = Modifier.height(24.dp)
      )

      Text(
        text = "Home",
        modifier = Modifier
          .fillMaxWidth()
          .clickable {
            onDismiss()
          }
          .padding(12.dp)
      )

      Text(
        text = "Settings",
        modifier = Modifier
          .fillMaxWidth()
          .clickable {
            onDismiss()
          }
          .padding(12.dp)
      )
    }

    // Clickable area outside the menu
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(start = 0.dp)
    )
  }
}