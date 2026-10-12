package com.example.wpn.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wpn.ui.components.DrawerItem
import com.example.wpn.ui.components.DrawerTextLarge
import com.example.wpn.ui.components.DrawerTextMedium
import com.example.wpn.ui.map.AppPage
import kotlinx.coroutines.launch

@Composable
fun AppDrawer(
  currentPage: AppPage,
  onPageSelected: (AppPage) -> Unit,
  content: @Composable (onMenuClick: () -> Unit) -> Unit
) {
  val drawerState = rememberDrawerState(DrawerValue.Closed)
  val scope = rememberCoroutineScope()

  fun onClick(page: AppPage) {
    onPageSelected(page)
    scope.launch {
      drawerState.close()
    }
  }

  ModalNavigationDrawer(
    drawerState = drawerState,
    drawerContent = {
      ModalDrawerSheet(
        modifier = Modifier.fillMaxWidth(0.7f),
        drawerContainerColor = MaterialTheme.colorScheme.surface,
        drawerContentColor = MaterialTheme.colorScheme.onSurface,
      ) {
        Column(
          modifier = Modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
        ) {
          Spacer(Modifier.height(12.dp))
          DrawerTextLarge(text="Menu")
          HorizontalDivider(color = MaterialTheme.colorScheme.surfaceVariant)

          Spacer(Modifier.height(12.dp))

          DrawerItem(
            itemPage=AppPage.HOME,
            currentPage = currentPage,
            onClick = { page -> onClick(page) }
          )

          Spacer(Modifier.height(12.dp))
          HorizontalDivider(color = MaterialTheme.colorScheme.surfaceVariant)
          DrawerTextMedium(text="Look ups")

          DrawerItem(
            itemPage=AppPage.TAGS,
            currentPage = currentPage,
            onClick = { page -> onClick(page) }
          )

          DrawerItem(
            itemPage=AppPage.DLCS,
            currentPage = currentPage,
            onClick = { page -> onClick(page) }
          )

          DrawerItem(
            itemPage=AppPage.QUESTS_MATCH,
            currentPage = currentPage,
            onClick = { page -> onClick(page) }
          )

          DrawerItem(
            itemPage=AppPage.QUESTS_PERSONAL,
            currentPage = currentPage,
            onClick = { page -> onClick(page) }
          )
        }
      }
    }
  ) {
    content {
      scope.launch {
        drawerState.open()
      }
    }
  }
}