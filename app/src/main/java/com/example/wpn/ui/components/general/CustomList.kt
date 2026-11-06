package com.example.wpn.ui.components.general

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp

@Composable
fun <T : Any> CustomList(
  modifier: Modifier = Modifier,
  items: List<T>,
  removeRow: (T) -> Unit,
  itemContent: @Composable (T) -> Unit
) {
  val dividerColor = MaterialTheme.colorScheme.surfaceVariant

  Column(
    modifier = modifier
      .background(
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(
          bottomStart = 12.dp,
          bottomEnd = 12.dp
        )
      )
      .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(4.dp),
  ) {
    items.forEach { item ->
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .drawBehind {
            drawLine(
              color = dividerColor,
              start = Offset(0f, 0f),
              end = Offset(size.width, 0f),
              strokeWidth = 2.dp.toPx()
            )
          }
          .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        itemContent(item)

        Spacer(modifier = Modifier.weight(1f))
        AppIcon(
          style = AppIconType.DELETE.toStyle(),
          onClick = { removeRow(item) },
          size = 40.dp,
          hasBorder = false
        )
      }
    }
  }
}