package com.example.wpn.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wpn.model.CommonCrudItemData
import com.example.wpn.model.MatchData
import com.example.wpn.model.PlayerItemData
import com.example.wpn.ui.components.DateField
import com.example.wpn.ui.components.ScoringBoolComponent
import java.time.LocalDate


@Composable
fun MatchEditPage(
  modifier: Modifier = Modifier,
  date: LocalDate?,
  dlcOptions: List<CommonCrudItemData>,
  matchQuestOptions: List<CommonCrudItemData>,
  matchData: MatchData,
  onUpdateClick: (PlayerItemData) -> Unit,
  onDeleteClick: (PlayerItemData) -> Unit
) {
  var hardScoring by remember { mutableStateOf(false) }
  var matchDate by remember { mutableStateOf(date?: LocalDate.now()) }

  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(16.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceEvenly
    ) {
      DateField(
        label = "Played At",
        date = matchDate,
        onDateChange = { matchDate = it }
      )

      ScoringBoolComponent(
        state= hardScoring,
        onStateChange = { hardScoring = it }
      )
    }
  }
}