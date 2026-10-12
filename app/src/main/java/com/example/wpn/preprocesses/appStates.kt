package com.example.wpn.preprocesses

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.wpn.ui.map.AppPage
import com.example.wpn.ui.map.CommonCrudItemData
import com.example.wpn.ui.map.PlayerMatchItemData
import com.example.wpn.ui.map.PlayerItemData
import java.time.LocalDate

sealed interface EditingItem {
  data class Tag(val item: CommonCrudItemData) : EditingItem
  data class DLC(val item: CommonCrudItemData) : EditingItem
  data class QuestPersonal(val item: CommonCrudItemData) : EditingItem
  data class QuestMatch(val item: CommonCrudItemData) : EditingItem
  data class Player(val item: PlayerItemData) : EditingItem
  data class PlayerMatch(val item: PlayerMatchItemData) : EditingItem
  object None : EditingItem
}

class AppUiState {
  var currentPage by mutableStateOf(AppPage.HOME)
  var date by mutableStateOf<LocalDate>(LocalDate.now())
  var darkTheme by mutableStateOf(true)
  var showAddSheet by mutableStateOf(false)
  var editingItem: EditingItem by mutableStateOf(EditingItem.None)

  fun openAdd() {
    editingItem = EditingItem.None
    showAddSheet = true
  }
  fun openEdit(item: EditingItem) {
    editingItem = item
    showAddSheet = true
  }
  fun closeSheet() {
    showAddSheet = false
    editingItem = EditingItem.None
  }
}

@Composable
fun rememberAppUiState() = remember { AppUiState() }
