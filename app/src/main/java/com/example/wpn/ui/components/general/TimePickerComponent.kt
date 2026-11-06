package com.example.wpn.ui.components.general

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun TimePickerComponent(
  modifier: Modifier = Modifier,
  label: String,
  time: LocalTime,
  openTimeDialog: (time: LocalTime, label: String) -> Unit,
  formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm")
) {
  Column(
    modifier = modifier
      .background(
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(12.dp)
      )
      .padding(horizontal = 30.dp, vertical = 12.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    CustomTextBoxPrimary(
      text = label
    )

    CustomTextBoxSecondary(
      modifier = Modifier
        .background(
          color = MaterialTheme.colorScheme.surfaceVariant,
          shape = RoundedCornerShape(8.dp)
        )
        .padding(8.dp)
        .clickable(
          onClick = {
            openTimeDialog(time, label)
          }
        ),
      text = time.format(formatter).toString()
    )
  }
}