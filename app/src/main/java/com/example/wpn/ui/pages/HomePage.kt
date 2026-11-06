package com.example.wpn.ui.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wpn.ui.components.StartEndTimeSelection
import com.example.wpn.ui.components.general.VerticalInput
import java.time.LocalTime

@Composable
fun HomeScreen(
  modifier: Modifier
) {
  val number = rememberTextFieldState("0")

  var isHard by remember { mutableStateOf(true) }

  var start by remember { mutableStateOf(LocalTime.now())}
  var end by remember { mutableStateOf(LocalTime.now().plusHours(1))}

  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(16.dp)
  ) {
    Text(
      text = "Home",
      style = MaterialTheme.typography.headlineMedium
    )

    Spacer(modifier = Modifier.height(16.dp))

    Text(
      text = "This is the main content area.",
      style = MaterialTheme.typography.bodyLarge
    )

    Spacer(modifier = Modifier.height(16.dp))

    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      VerticalInput(
        modifier = Modifier.weight(1f),
        header = "Egg Count",
        number = number
      )

      VerticalInput(
        modifier = Modifier.weight(1f),
        header = "Chicken Count",
        number = number
      )
    }

    Spacer(modifier = Modifier.height(16.dp))

    StartEndTimeSelection(
      start = start,
      end = end,
      onStartChange = { newTime ->
        start = newTime
      },
      onEndChange = { newTime ->
        end = newTime
      }
    )
  }
}