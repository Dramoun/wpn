package com.example.wpn.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wpn.model.CommonCrudItemData

@Composable
fun CrudItemComponent (
  modifier: Modifier = Modifier,
  item: CommonCrudItemData,
  onItemClick: (CommonCrudItemData) -> Unit = {},
) {
  Card(
    modifier = modifier.fillMaxWidth().clickable { onItemClick(item) }
  ) {
    Row(
      modifier = Modifier.fillMaxWidth().padding(12.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      CustomTextBoxPrimary( text=item.name )
      CustomTextBoxSecondary( text=item.name )
    }
  }
}