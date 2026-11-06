package com.example.wpn.ui.components.general

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.wpn.ui.theme.SuccessColor


@Composable
fun Toggle(
  modifier: Modifier = Modifier,
  state: Boolean,
  trueStyle: IconStyle = AppIconType.SAD_FACE.toStyle(),
  falseStyle: IconStyle = AppIconType.SMILE_FACE.toStyle(),
  size: Dp = 48.dp,
  onStateChange: (Boolean) -> Unit
) {

  val trueStyle = IconStyle(
    icon = trueStyle.icon,
    contentDescription = trueStyle.contentDescription,
    color = MaterialTheme.colorScheme.error,
    background = trueStyle.background
  )

  val falseStyle = IconStyle(
    icon = falseStyle.icon,
    contentDescription = falseStyle.contentDescription,
    color = SuccessColor,
    background = falseStyle.background
  )

  Box(
    modifier = modifier
      .size(size)
      .clip(CircleShape)
      .clickable { onStateChange(!state) }
  ) {
    AppIcon(
      style = if (state) trueStyle else falseStyle,
      size = size,
      onClick = null,
      hasBorder = true,
      useIconStyleColors = true
    )
  }
}