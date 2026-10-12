package com.example.wpn.ui.overlay

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wpn.ui.theme.SuccessColor

@Composable
fun <T>OverLayFooter(
  itemData: T,
  itemExists: Boolean,
  onDismiss: () -> Unit,
  onDelete: (T) -> Unit,
  onAdd: (T) -> Unit
){
  Row(
    modifier = Modifier.fillMaxWidth().padding(16.dp),
    horizontalArrangement = Arrangement.SpaceAround
  ) {
    if (itemExists) {
      Button(
        onClick = {
          onDelete(itemData)
        },
        colors = ButtonDefaults.buttonColors(
          contentColor = MaterialTheme.colorScheme.error,
          containerColor = MaterialTheme.colorScheme.surface
        )
      ) {
        Text("Delete")
      }
    }
    TextButton(onClick = onDismiss) {
      Text("Cancel")
    }

    Button(
      onClick = {
        onAdd(itemData)
      },
      colors = ButtonDefaults.buttonColors(
        contentColor = SuccessColor,
        containerColor = MaterialTheme.colorScheme.surfaceVariant
      )
    ) {
      Text("Save")
    }
  }
}