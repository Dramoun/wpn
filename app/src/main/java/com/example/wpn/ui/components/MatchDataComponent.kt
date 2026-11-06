package com.example.wpn.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wpn.ui.components.general.CustomTextBoxPrimary
import com.example.wpn.ui.components.general.CustomTextBoxSecondary
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@Composable
fun MatchDataComponent(
  modifier: Modifier = Modifier,
  hsPlayerShortName: String,
  hsPlayerScore: Int,
  playedAt: LocalDateTime,
  duration: Int,
  totalPlayers: Int,
  onMatchClick: () -> Unit
) {
  val playedAtFormatter = DateTimeFormatter.ofPattern("dd MM yyyy")

  Row(
    modifier = modifier
      .padding(12.dp)
      .clickable(
        onClick = { onMatchClick() }
      ),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    CustomTextBoxPrimary(
      text = hsPlayerShortName,
      bold = true
    )

    CustomTextBoxPrimary(
      text = hsPlayerScore.toString()
    )

    CustomTextBoxSecondary(
      text = playedAt.format(playedAtFormatter).toString()
    )

    CustomTextBoxPrimary(
      text = duration.toString()
    )

    CustomTextBoxSecondary(
      text = totalPlayers.toString()
    )
  }
}