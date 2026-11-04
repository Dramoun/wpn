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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateField(
  modifier: Modifier = Modifier,
  label: String,
  date: LocalDate,
  onDateChange: (LocalDate) -> Unit,
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
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    CustomTextBoxPrimary(
      text = label
    )
    CustomTextBoxSecondary(
      modifier = Modifier.clickable { showPicker = true },
      text = date.format(formatter)
    )
  }

  if (showPicker) {
    val state = rememberDatePickerState(
      initialSelectedDateMillis = date.toEpochMillisUtc()
    )

    DatePickerDialog(
      onDismissRequest = { showPicker = false },
      confirmButton = {
        TextButton(onClick = {
          state.selectedDateMillis?.let { onDateChange(it.toLocalDateUtc()) }
          showPicker = false
        }) {
          CustomTextBoxPrimary(
            text = "OK"
          )
        }
      },
      dismissButton = {
        TextButton(
          onClick = { showPicker = false }
        ) {
          CustomTextBoxSecondary(
            text = "Cancel"
          )
        }
      }
    ) {
      DatePicker(state = state)
    }
  }
}

internal fun LocalDate.toEpochMillisUtc(): Long =
  atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()

internal fun Long.toLocalDateUtc(): LocalDate =
  Instant.ofEpochMilli(this).atZone(ZoneOffset.UTC).toLocalDate()
