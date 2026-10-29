package com.example.wpn.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalDataComponent (
  modifier: Modifier = Modifier,
  header: String,
  text: String
) {
  Row(
    modifier = modifier.fillMaxWidth().padding(12.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    CustomTextBoxPrimary( text=header )
    CustomTextBoxSecondary( text=text )
  }
}