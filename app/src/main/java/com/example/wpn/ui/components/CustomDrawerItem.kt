package com.example.wpn.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wpn.ui.map.AppPage


@Composable
fun DrawerItem(
  modifier: Modifier = Modifier,
  itemPage: AppPage,
  currentPage: AppPage,
  onClick: (AppPage) -> Unit
){
  NavigationDrawerItem(
    modifier = modifier.height(40.dp),
    label = {
      Text(
        modifier= Modifier.padding(start = 10.dp),
        text=itemPage.label
      )},
    selected = currentPage == itemPage,
    onClick = {
      onClick(itemPage)
    }
  )
}

