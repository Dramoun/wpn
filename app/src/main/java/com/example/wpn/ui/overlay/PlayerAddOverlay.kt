package com.example.wpn.ui.overlay

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.wpn.model.PlayerItemData
import java.time.LocalDateTime

@Composable
fun PlayerAddOverlay(
  updateItem: PlayerItemData?,
  onDismiss: () -> Unit,
  onDelete: (PlayerItemData) -> Unit,
  onAdd: (PlayerItemData) -> Unit
) {
  val name = rememberTextFieldState(initialText = updateItem?.name ?: "")
  val shortName = rememberTextFieldState(initialText = updateItem?.shortName ?: "")

  Dialog(onDismissRequest = onDismiss) {
    Card{
      Column(
        modifier = Modifier
          .padding(16.dp)
          .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        Text(if (updateItem != null) "Update Task" else "Add Task")

        OutlinedTextField(
          state = name,
          label = { Text("Name") },
          modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
          state = shortName,
          inputTransformation = InputTransformation.maxLength(3),
          label = { Text("Max len of 3") },
          modifier = Modifier.fillMaxWidth()
        )

        OverLayFooter(
          itemData = PlayerItemData(
            name = name.text.toString(),
            shortName = shortName.text.toString(),
            joinedAt = updateItem?.joinedAt ?: LocalDateTime.now(),
            id = updateItem?.id,
            lastPlayed = updateItem?.lastPlayed,
            totalGames = updateItem?.totalGames,
            totalWins = updateItem?.totalWins,
            averageScore = updateItem?.averageScore,
            highScore = updateItem?.highScore,
            lowScore = updateItem?.lowScore
          ),
          itemExists = updateItem != null,
          onDismiss = onDismiss,
          onDelete = onDelete,
          onAdd = onAdd
        )
      }
    }
  }
}