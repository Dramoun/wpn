package com.example.wpn.ui.components.general

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextBoxPrimary(
  modifier: Modifier = Modifier,
  text: String,
  color: Color = MaterialTheme.colorScheme.primary,
  bold: Boolean = false,
  background: Color? = null,
) {
  Text(
    modifier = modifier
      .then(
        if (background != null) {
          Modifier
            .background(
              color = background,
              shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 12.dp, vertical = 8.dp)
        } else {
          Modifier
        }
      ),
    text = text,
    color = color,
    fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal,
    style = MaterialTheme.typography.bodyLarge
  )
}

@Composable
fun CustomTextBoxSecondary(
  modifier: Modifier = Modifier,
  text: String,
  color: Color = MaterialTheme.colorScheme.secondary,
  bold: Boolean = false,
  background: Color? = null,
) {
  Text(
    modifier = modifier.then(
      if (background != null) {
        Modifier
          .background(
            color = background,
            shape = RoundedCornerShape(8.dp)
          )
          .padding(horizontal = 12.dp, vertical = 8.dp)
      } else {
        Modifier
      }
    ),
    text = text,
    color = color,
    fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal,
    style = MaterialTheme.typography.bodyLarge
  )
}