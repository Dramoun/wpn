package com.example.wpn.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wpn.model.PlayerItemData
import com.example.wpn.ui.components.PlayerListingComponent

@Composable
fun PlayerListPage(
  modifier: Modifier = Modifier,
  playerList: List<PlayerItemData>,
  onPlayerClick: (PlayerItemData) -> Unit
) {
  Column(
    modifier = modifier.fillMaxSize().padding(16.dp)
  ) {
    LazyColumn(
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      items(playerList) { playerData ->
        PlayerListingComponent(
          onPlayerClick = { onPlayerClick(playerData)},
          playerData = playerData
        )
      }
    }
  }
}