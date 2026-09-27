package com.example.wpn.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.PaddingValues

@Composable
fun HomeScreen(
  innerPadding: PaddingValues
) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(innerPadding)
      .padding(16.dp)
  ) {

    Text(
      text = "Home",
      style = MaterialTheme.typography.headlineMedium
    )

    Spacer(
      modifier = Modifier.height(16.dp)
    )

    Text(
      text = "This is the main content area.",
      style = MaterialTheme.typography.bodyLarge
    )
  }
}