package com.example.wpn.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wpn.model.PlayerItemData
import com.example.wpn.ui.components.general.AppIcon
import com.example.wpn.ui.components.general.AppIconType
import com.example.wpn.ui.components.general.HorizontalData
import com.example.wpn.ui.components.general.VerticalData
import com.example.wpn.ui.components.general.toStyle


@Composable
fun PlayerDetailsPage(
  modifier: Modifier = Modifier,
  playerInfo: PlayerItemData,
  onUpdateClick: (PlayerItemData) -> Unit,
  onDeleteClick: (PlayerItemData) -> Unit
) {

  val winrate = if (
    playerInfo.totalGames == 0 ||
    playerInfo.totalGames == null ||
    playerInfo.totalWins == null
    ) {
    0.0
  } else {
    (playerInfo.totalWins.toDouble() / playerInfo.totalGames.toDouble()) * 100
  }

  Column(
    modifier = modifier.fillMaxSize().padding(16.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth().padding(12.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      AppIcon(
        style = AppIconType.ADD.toStyle(),
        onClick = {onUpdateClick(playerInfo)}
      )

      AppIcon(
        style = AppIconType.DELETE.toStyle(),
        onClick = {onDeleteClick(playerInfo)}
      )
    }

    Row(
      modifier = Modifier.fillMaxWidth().padding(12.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      VerticalData(
        header="High Score",
        text=playerInfo.highScore?.toString() ?: "0"
      )

      // TODO: this should be custom component
      VerticalData(
        header=" ",
        text=playerInfo.shortName
      )

      VerticalData(
        header="Winrate",
        text="${winrate.toInt()}%"
      )
    }

    Column(
      modifier = Modifier.fillMaxWidth().padding(12.dp)
    ) {
      HorizontalData(
        header="Wins",
        text=playerInfo.totalWins?.toString() ?: "0"
      )

      HorizontalData(
        header="Average Score",
        text=playerInfo.averageScore?.toString() ?: "0"
      )

      HorizontalData(
        header="Low Score",
        text=playerInfo.lowScore?.toString() ?: "0"
      )

      HorizontalData(
        header="Total games",
        text=playerInfo.totalGames?.toString() ?: "0"
      )

      HorizontalData(
        header="Last game played",
        text=playerInfo.lastPlayed?.toLocalDate().toString()
      )

      HorizontalData(
        header="Joined",
        text=playerInfo.joinedAt.toLocalDate().toString()
      )
    }
  }
}
