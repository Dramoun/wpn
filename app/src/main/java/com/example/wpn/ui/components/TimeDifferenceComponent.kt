package com.example.wpn.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wpn.ui.components.general.CustomTextBoxPrimary
import com.example.wpn.ui.components.general.CustomTextBoxSecondary

@Composable
fun TimeDifferenceComponent(
  modifier: Modifier = Modifier,
  totalMinutes: Int,
) {
  Column(
    modifier = modifier
      .background(
        MaterialTheme.colorScheme.surface,
        RoundedCornerShape(16.dp)
      )
      .padding(horizontal = 16.dp, vertical = 12.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(4.dp)
  ) {
    CustomTextBoxSecondary(text = "DURATION")

    CustomTextBoxPrimary(
      text = "$totalMinutes min",
      bold = true
    )
  }
}