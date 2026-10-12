package com.example.wpn.ui.navigation

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.example.wpn.ui.components.AppIcon
import com.example.wpn.ui.components.AppIcons
import com.example.wpn.model.AppPage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
  page: AppPage,
  onMenuClick: () -> Unit,
  playerName: String?
) {
  CenterAlignedTopAppBar(
    title = {
      Text(
        text = if (page == AppPage.PLAYER_DETAILS) {
          playerName?: page.label
        } else { page.label },
        color = MaterialTheme.colorScheme.primary,
      )},
    navigationIcon = {
      IconButton(onClick = onMenuClick) {
        AppIcon(style = AppIcons.Menu())
      }
    },
    // TODO: no feature currently here but button is ready
    actions = {
      IconButton(onClick = { }) {
        AppIcon(style = AppIcons.More())
      }
    },
    colors = TopAppBarDefaults.topAppBarColors(
      containerColor = MaterialTheme.colorScheme.surface,
      scrolledContainerColor = MaterialTheme.colorScheme.surface,
      navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
      titleContentColor = MaterialTheme.colorScheme.onPrimary,
      actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
    )
  )
}