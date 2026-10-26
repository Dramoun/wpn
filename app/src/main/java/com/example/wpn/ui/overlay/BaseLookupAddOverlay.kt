package com.example.wpn.ui.overlay

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.wpn.model.CommonCrudItemData

@Composable
fun BaseLookupAddOverlay(
  updateItem: CommonCrudItemData?,
  onDismiss: () -> Unit,
  onDelete: (CommonCrudItemData) -> Unit,
  onAdd: (CommonCrudItemData) -> Unit
) {
  val name = rememberTextFieldState(initialText = updateItem?.name ?: "")
  val description = rememberTextFieldState(initialText = updateItem?.description ?: "")

  Dialog(onDismissRequest = onDismiss) {
    Card{
      Column(
        modifier = Modifier
          .padding(16.dp)
          .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        Text(if (updateItem != null) "Update Item" else "Add Item")

        OutlinedTextField(
          state = name,
          label = { Text("Name") },
          modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
          state = description,
          label = { Text("Description") },
          modifier = Modifier.fillMaxWidth()
        )

        OverLayFooter(
          itemData = CommonCrudItemData(
            name = name.text.toString(),
            description = description.text.toString().ifBlank { null },
            id = updateItem?.id
          ),
          itemExists = updateItem != null,
          onDismiss = onDismiss,
          onDelete = onDelete,
          onAdd = onAdd
        )
      }
    }
  }
}