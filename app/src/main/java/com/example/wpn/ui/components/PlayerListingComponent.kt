package com.example.wpn.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wpn.model.PlayerItemData

@Composable
fun PlayerListingComponent (
  modifier: Modifier = Modifier,
  onPlayerClick: (playerId: Long) -> Unit = {},
  playerData: PlayerItemData
) {
  Card(
    modifier = modifier.fillMaxWidth().clickable { onPlayerClick(playerData.id?: 0) }
  ) {
    Row(
      modifier = Modifier.fillMaxWidth().padding(12.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      CustomTextBoxPrimary( text = playerData.shortName)
      CustomTextBoxSecondary( text = playerData.highScore?.toString() ?: "0")
      CustomTextBoxSecondary( text = playerData.totalWins?.toString() ?: "0")
      CustomTextBoxPrimary( text = playerData.totalGames?.toString() ?: "0")
    }
  }
}