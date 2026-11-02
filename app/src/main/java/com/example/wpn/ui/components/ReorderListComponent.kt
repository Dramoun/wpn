package com.example.wpn.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlin.math.roundToInt

@Composable
fun <T : Any> ReorderListComponent(
  modifier: Modifier = Modifier,
  items: List<T>,
  removeRow: (T) -> Unit,
  moveItem: (Int, Int) -> Unit,
  keyOf: (T) -> Any = { it },
  itemContent: @Composable (T) -> Unit
) {
  val dividerColor = MaterialTheme.colorScheme.surfaceVariant

  val rowHeights = remember { mutableStateMapOf<Any, Float>() }

  val density = LocalDensity.current
  val spacingPx = with(density) { 4.dp.toPx() }

  val currentItems by rememberUpdatedState(items)
  val currentKeyOf by rememberUpdatedState(keyOf)
  val currentMoveItem by rememberUpdatedState(moveItem)

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
    items.forEachIndexed { index, item ->
      val itemKey = keyOf(item)

      key(itemKey) {
        var offsetY by remember { mutableFloatStateOf(0f) }

        val currentIndex by rememberUpdatedState(index)

        fun onRelease() {
          val heights = currentItems.map { currentKeyOf(it).let { k -> rowHeights[k] ?: 0f } }
          val from = currentIndex
          if (from !in heights.indices) {
            offsetY = 0f
            return
          }

          val myHeight = heights[from]
          val originalTop = heights.take(from).sum() + from * spacingPx
          val center = originalTop + offsetY + myHeight / 2f

          var accumulated = 0f
          var target = heights.lastIndex
          for (j in heights.indices) {
            val slot = heights[j] + spacingPx
            if (center < accumulated + slot) {
              target = j
              break
            }
            accumulated += slot
          }

          if (target != from) {
            currentMoveItem(from, target)
          }

          offsetY = 0f
        }

        Row(
          modifier = Modifier
            .fillMaxWidth()
            .zIndex(if (offsetY != 0f) 1f else 0f)
            .onSizeChanged { size ->
              rowHeights[itemKey] = size.height.toFloat()
            }
            .pointerInput(Unit) {
              detectDragGestures(
                onDragEnd = { onRelease() },
                onDragCancel = { onRelease() }
              ) { change, dragAmount ->
                change.consume()
                offsetY += dragAmount.y
              }
            }
            .offset {
              IntOffset(x = 0, y = offsetY.roundToInt())
            }
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
          CustomTextBoxPrimary(
            text = "${index + 1}."
          )
          Spacer(modifier = Modifier.width(8.dp))

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
}