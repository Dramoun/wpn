package com.example.wpn.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wpn.model.CommonCrudItemData
import com.example.wpn.model.MatchData
import com.example.wpn.model.PlayerItemData
import com.example.wpn.ui.components.DateField
import com.example.wpn.ui.components.general.ReorderList
import com.example.wpn.ui.components.ScoringBool
import com.example.wpn.ui.components.general.SearchDropDown
import com.example.wpn.ui.components.StartEndTimeSelection
import com.example.wpn.ui.helpers.minutesBetween
import java.time.LocalDateTime
import java.time.LocalTime


@Composable
fun MatchEditPage(
  modifier: Modifier = Modifier,
  date: LocalDateTime?,
  dlcOptions: List<CommonCrudItemData>,
  matchQuestOptions: List<CommonCrudItemData>,
  matchData: MatchData,
  onUpdateClick: (PlayerItemData) -> Unit,
  onDeleteClick: (PlayerItemData) -> Unit
) {
  var hardScoring by remember { mutableStateOf(false) }
  var matchDate by remember { mutableStateOf(date ?: LocalDateTime.now()) }
  var start by remember { mutableStateOf(LocalTime.now()) }
  var end by remember { mutableStateOf(LocalTime.now().plusHours(1)) }

  val duration = minutesBetween(start, end)

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
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceEvenly
    ) {
      DateField(
        label = "Played At",
        date = matchDate,
        onDateChange = { matchDate = it }
      )

      ScoringBool(
        state = hardScoring,
        onStateChange = { hardScoring = it }
      )
    }

    Spacer(modifier = Modifier.height(16.dp))

    StartEndTimeSelection(
      start = start,
      end = end,
      onStartChange = { start = it },
      onEndChange = { end = it }
    )

    Spacer(modifier = Modifier.height(16.dp))

    SearchDropDown(
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

    ReorderList(
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