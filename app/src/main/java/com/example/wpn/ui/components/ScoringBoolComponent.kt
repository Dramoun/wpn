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
import com.example.wpn.ui.components.general.ToggleComponent


@Composable
fun ScoringBoolComponent(
  modifier: Modifier = Modifier,
  state: Boolean,
  onStateChange: (Boolean) -> Unit
) {
  Column(
    modifier = modifier
      .background(
        MaterialTheme.colorScheme.surface,
        RoundedCornerShape(20.dp)
      )
      .padding(horizontal = 44.dp, vertical = 20.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    CustomTextBoxPrimary(
      text = "Scoring"
    )
    ToggleComponent(
      state = state,
      onStateChange = onStateChange
    )
  }
}
