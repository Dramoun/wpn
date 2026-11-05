package com.example.wpn.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateField(
  modifier: Modifier = Modifier,
  label: String,
  date: LocalDateTime,
  onDateChange: (LocalDateTime) -> Unit,
  formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd MM yyyy")
) {
  var showPicker by remember { mutableStateOf(false) }

  Column(
    modifier = modifier
      .background(
        MaterialTheme.colorScheme.surface,
        RoundedCornerShape(20.dp)
      )
      .padding(24.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    CustomTextBoxPrimary(text = label)
    CustomTextBoxSecondary(
      modifier = Modifier
        .background(
          color = MaterialTheme.colorScheme.surfaceVariant,
          shape = RoundedCornerShape(8.dp)
        )
        .padding(8.dp)
        .clickable { showPicker = true },
      text = date.format(formatter)
    )
  }

  if (showPicker) {
    val pickerState = rememberDatePickerState(
      initialSelectedDateMillis = date.toEpochMillisUtc()
    )

    DatePickerDialog(
      onDismissRequest = { showPicker = false },
      confirmButton = {
        TextButton(onClick = {
          pickerState.selectedDateMillis?.let { onDateChange(it.toLocalDateTimeUtc()) }
          showPicker = false
        }) { CustomTextBoxPrimary(text = "OK") }
      },
      dismissButton = {
        TextButton(onClick = { showPicker = false }) {
          CustomTextBoxSecondary(text = "Cancel")
        }
      }
    ) {
      DatePicker(state = pickerState)
    }
  }
}

private fun LocalDateTime.toEpochMillisUtc(): Long =
  toInstant(ZoneOffset.UTC).toEpochMilli()

private fun Long.toLocalDateTimeUtc(): LocalDateTime =
  LocalDateTime.ofInstant(Instant.ofEpochMilli(this), ZoneOffset.UTC)