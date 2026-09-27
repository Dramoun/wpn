package com.example.wpn.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
  showBackButton: Boolean,
  onMenuClick: () -> Unit,
  onBackClick: () -> Unit,
  onThemeClick: () -> Unit
) {
  TopAppBar(

    title = {
      Text(
        text = "My App",
        style = MaterialTheme.typography.titleLarge
      )
    },

    navigationIcon = {

      if (showBackButton) {

        IconButton(
          onClick = onBackClick
        ) {
          Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back"
          )
        }

      } else {

        IconButton(
          onClick = onMenuClick
        ) {
          Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Menu"
          )
        }
      }
    },

    actions = {

      IconButton(
        onClick = onThemeClick
      ) {
        Icon(
          imageVector = Icons.Default.DarkMode,
          contentDescription = "Change theme"
        )
      }
    }
  )
}