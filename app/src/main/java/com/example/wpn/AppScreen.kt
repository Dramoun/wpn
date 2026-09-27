package com.example.wpn

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.wpn.ui.components.TopBar
import com.example.wpn.ui.components.SideMenu
import com.example.wpn.ui.components.AppFloatingButton
import com.example.wpn.ui.screens.HomeScreen
import com.example.wpn.ui.theme.AppTheme

@Composable
fun AppScreen() {

  var darkTheme by remember {
    mutableStateOf(false)
  }

  var menuOpen by remember {
    mutableStateOf(false)
  }

  AppTheme(
    darkTheme = darkTheme
  ) {

    Scaffold(
      modifier = Modifier.fillMaxSize(),

      topBar = {
        TopBar(
          showBackButton = false,
          onMenuClick = {
            menuOpen = true
          },
          onBackClick = {
            // Back handling later
          },
          onThemeClick = {
            darkTheme = !darkTheme
          }
        )
      },

      floatingActionButton = {
        AppFloatingButton(
          onClick = {
            // Page-specific action
          }
        )
      }
    ) { innerPadding ->

      HomeScreen(
        innerPadding = innerPadding
      )

      if (menuOpen) {
        SideMenu(
          onDismiss = {
            menuOpen = false
          }
        )
      }
    }
  }
}