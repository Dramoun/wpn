package com.example.wpn.ui.components.general

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun VerticalDataComponent (
  modifier: Modifier = Modifier,
  header: String,
  text: String
) {
  Column(
    modifier = modifier.padding(12.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    CustomTextBoxPrimary(text = header)
    CustomTextBoxSecondary(text = text)
  }
}

@Composable
fun VerticalInputComponent(
  modifier: Modifier = Modifier,
  header: String,
  number: TextFieldState
) {
  Column(
    modifier = modifier
      .background(
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(12.dp)
      )
      .padding(12.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    CustomTextBoxPrimary(text = header)

    TextField(
      state = number,
      modifier = Modifier
        .width(120.dp)
        .height(56.dp),
      textStyle = MaterialTheme.typography.bodyLarge.copy(
        textAlign = TextAlign.Center
      ),
      keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Number
      ),
      shape = RoundedCornerShape(10.dp),
      lineLimits = TextFieldLineLimits.SingleLine,
      colors = TextFieldDefaults.colors(
        focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
        unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent
      )
    )
  }
}