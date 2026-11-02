package com.example.wpn.ui.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wpn.ui.components.ReorderListComponent
import com.example.wpn.ui.components.SearchDropDownComponent

@Composable
fun HomeScreen(
  modifier: Modifier
) {
  val testItems = remember {
    mutableStateListOf(
      "First item",
      "Second item",
      "Third item",
      "Fourth item",
      "Fifth item"
    )
  }

  val options = remember {
    mapOf(
      1L to "Apple",
      2L to "Banana",
      3L to "Orange",
      4L to "Strawberry",
      5L to "Watermelon",
      6L to "Pineapple",
      7L to "Mango"
    )
  }

  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(16.dp)
  ) {
    Text(
      text = "Home",
      style = MaterialTheme.typography.headlineMedium
    )

    Spacer(modifier = Modifier.height(16.dp))

    Text(
      text = "This is the main content area.",
      style = MaterialTheme.typography.bodyLarge
    )

    Spacer(modifier = Modifier.height(16.dp))

    SearchDropDownComponent(
      options = options,
      headerText = "Add an item",
      hint = "Search items",
      lastItemContent = {
        Text("Add custom item")
      },
      onItemSelected = { id ->
        val selectedItem = options[id]

        if (selectedItem != null && selectedItem !in testItems) {
          testItems.add(selectedItem)
        }
      },
      onLastItemClick = {
        testItems.add("Custom item ${testItems.size + 1}")
      }
    )

    ReorderListComponent(
      modifier = Modifier.fillMaxWidth(),
      items = testItems,
      removeRow = { item ->
        testItems.remove(item)
      },
      moveItem = { originalIndex, targetIndex ->
        val item = testItems.removeAt(originalIndex)
        testItems.add(targetIndex, item)
      }
    ) { item ->
      Text(
        text = item,
        style = MaterialTheme.typography.bodyLarge
      )
    }
  }
}