package com.example.wpn.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.wpn.ui.helpers.minutesBetween
import java.time.LocalTime


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartEndTimeSelectionComponent(
  modifier: Modifier = Modifier,
  start: LocalTime,
  end: LocalTime,
  onStartChange: (LocalTime) -> Unit,
  onEndChange: (LocalTime) -> Unit
) {
  var showPicker by remember { mutableStateOf(false) }
  var selectedTime by remember { mutableStateOf(start) }
  var selectedLabel by remember { mutableStateOf("Start") }

  Row(
    modifier = modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceAround,
    verticalAlignment = Alignment.CenterVertically
  ) {
    TimePickerComponent(
      label = "Start",
      time = start,
      openTimeDialog = { time, label ->
        selectedTime = time
        selectedLabel = label
        showPicker = true
      }
    )

    TimeDifferenceComponent(
      totalMinutes = minutesBetween(start, end)
    )

    TimePickerComponent(
      label = "End",
      time = end,
      openTimeDialog = { time, label ->
        selectedTime = time
        selectedLabel = label
        showPicker = true
      }
    )
  }

  if (showPicker) {
    TimeDialDialog(
      label = selectedLabel,
      time = selectedTime,
      onConfirm = { newTime ->
        if (selectedLabel == "Start") onStartChange(newTime) else onEndChange(newTime)
        showPicker = false
      },
      onDismiss = { showPicker = false }
    )
  }
}