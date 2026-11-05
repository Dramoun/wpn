package com.example.wpn.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import java.time.LocalTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeDialDialog(
  label: String,
  time: LocalTime,
  onConfirm: (LocalTime) -> Unit,
  onDismiss: () -> Unit,
) {
  val timePickerState = rememberTimePickerState(
    initialHour = time.hour,
    initialMinute = time.minute,
    is24Hour = true,
  )

  Dialog(onDismissRequest = onDismiss) {
    Card(
      modifier = Modifier.fillMaxWidth(),
      shape = RoundedCornerShape(24.dp),
      colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surface
      )
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
      ) {
        CustomTextBoxPrimary(
          text = label,
          bold = true
        )

        TimePicker(
          state = timePickerState,
          modifier = Modifier.align(Alignment.CenterHorizontally),
        )

        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceEvenly,
          verticalAlignment = Alignment.CenterVertically
        ) {
          CustomTextBoxSecondary(
            modifier = Modifier
              .clickable(
                onClick = onDismiss
              ),
            text = "Cancel"
          )

          CustomTextBoxPrimary(
            modifier = Modifier
              .clickable(
                onClick = {
                  onConfirm(
                    LocalTime.of(
                      timePickerState.hour,
                      timePickerState.minute
                    )
                  )
                }
              ),
            text = "OK",
            bold = true,
            background = MaterialTheme.colorScheme.surfaceVariant
          )
        }
      }
    }
  }
}