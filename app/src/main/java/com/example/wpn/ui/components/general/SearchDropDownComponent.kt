package com.example.wpn.ui.components.general

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//TODO: used items shouldn't be hinted
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchDropDownComponent(
  modifier: Modifier = Modifier,
  options: Map<Long, String>,
  headerText: String,
  hint: String?,
  lastItemContent: @Composable () -> Unit,
  onItemSelected: (id: Long) -> Unit,
  onLastItemClick: () -> Unit,
) {
  var expanded by remember { mutableStateOf(false) }
  val searchText = rememberTextFieldState(initialText = "")

  val displayOptions = options.filter {
    it.value.contains(searchText.text, ignoreCase = true)
  }

  Column(
    modifier = modifier
      .fillMaxWidth()
      .background(
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(
          topStart = 12.dp,
          topEnd = 12.dp
        )
      )
      .padding(16.dp)
  ) {
    CustomTextBoxPrimary(text = headerText)

    ExposedDropdownMenuBox(
      expanded = expanded,
      onExpandedChange = { expanded = !expanded }
    ) {
      OutlinedTextField(
        state = searchText,
        label = { Text(hint ?: "") },
        modifier = Modifier
          .fillMaxWidth()
          .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryEditable)
      )

      ExposedDropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
      ) {
        displayOptions.forEach{ (id, value) ->
          DropdownMenuItem(
            text = {Text(value)},
            onClick = {
              expanded = false
              onItemSelected(id)
            }
          )
        }

        DropdownMenuItem(
          text = lastItemContent,
          onClick = {
            onLastItemClick()
          }
        )
      }
    }
  }
}