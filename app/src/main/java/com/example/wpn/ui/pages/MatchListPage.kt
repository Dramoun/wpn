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
import com.example.wpn.model.MatchData
import com.example.wpn.model.PlayerItemData
import com.example.wpn.ui.components.MatchDataItem

@Composable
fun MatchListPage(
  modifier: Modifier = Modifier,
  matchesList: List<MatchData>,
  getPlayerData: (id: Long) -> PlayerItemData,
  onMatchClick: (MatchData) -> Unit
) {
  Column(
    modifier = modifier.fillMaxSize().padding(16.dp)
  ) {
    LazyColumn(
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      items(matchesList) { matchData ->
        val hsPlayerMatchData = matchData.playerDataList.maxBy { player -> player.totalScore }
        val hsPlayer = getPlayerData(hsPlayerMatchData.id)

        MatchDataItem(
          hsPlayerShortName = hsPlayer.shortName,
          hsPlayerScore = hsPlayerMatchData.totalScore,
          playedAt = matchData.playedAt!!,
          duration = matchData.duration,
          totalPlayers = matchData.playerDataList.size,
          onMatchClick = { onMatchClick(matchData) }
        )
      }
    }
  }
}