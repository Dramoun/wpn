package com.example.wpn.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DrawerTextLarge(
  modifier: Modifier = Modifier,
  text: String
){
  Text(
    text = text,
    modifier = modifier.padding(16.dp),
    style = MaterialTheme.typography.titleLarge
  )
}

@Composable
fun DrawerTextMedium(
  modifier: Modifier = Modifier,
  text: String
){
  Text(
    text = text,
    modifier = modifier.padding(16.dp),
    style = MaterialTheme.typography.titleMedium
  )
}

@Composable
fun DrawerTextSmall(
  modifier: Modifier = Modifier,
  text: String
){
  Text(
    text = text,
    modifier = modifier.padding(16.dp),
    style = MaterialTheme.typography.titleSmall
  )
}