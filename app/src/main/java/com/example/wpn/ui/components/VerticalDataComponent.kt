package com.example.wpn.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    CustomTextBoxPrimary( text=header )
    CustomTextBoxSecondary( text=text )
  }
}