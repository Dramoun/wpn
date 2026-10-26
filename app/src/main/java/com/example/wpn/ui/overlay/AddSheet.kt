package com.example.wpn.ui.overlay

import androidx.compose.runtime.Composable
import com.example.wpn.preprocesses.EditingItem
import com.example.wpn.model.AppPage

@Composable
fun AddSheet(
  currentPage: AppPage,
  editingItem: EditingItem,
  onDismiss: () -> Unit,
  onSave: (EditingItem, isUpdate: Boolean) -> Unit,
  onDelete: (EditingItem) -> Unit
) {
  when (currentPage) {
    AppPage.HOME -> null

    AppPage.PLAYER_DETAILS,
    AppPage.PLAYER_LIST -> {
      val existing = (editingItem as? EditingItem.Player)?.item
      PlayerAddOverlay(
        updateItem = existing,
        onDismiss = onDismiss,
        onDelete = { onDelete(EditingItem.Player(it)) },
        onAdd = { onSave(EditingItem.Player(it), existing != null) }
      )
    }

    AppPage.MATCH_LIST -> null

    AppPage.TAGS -> {
      val existing = (editingItem as? EditingItem.Tag)?.item
      BaseLookupAddOverlay(
        updateItem = existing,
        onDismiss = onDismiss,
        onDelete = { onDelete(EditingItem.Tag(it)) },
        onAdd = { onSave(EditingItem.Tag(it), existing != null) }
      )
    }

    AppPage.DLCS -> {
      val existing = (editingItem as? EditingItem.DLC)?.item
      BaseLookupAddOverlay(
        updateItem = existing,
        onDismiss = onDismiss,
        onDelete = { onDelete(EditingItem.DLC(it)) },
        onAdd = { onSave(EditingItem.DLC(it), existing != null) }
      )
    }

    AppPage.QUESTS_MATCH-> {
      val existing = (editingItem as? EditingItem.QuestMatch)?.item
      BaseLookupAddOverlay(
        updateItem = existing,
        onDismiss = onDismiss,
        onDelete = { onDelete(EditingItem.QuestMatch(it)) },
        onAdd = { onSave(EditingItem.QuestMatch(it), existing != null) }
      )
    }

    AppPage.QUESTS_PERSONAL -> {
      val existing = (editingItem as? EditingItem.QuestPersonal)?.item
      BaseLookupAddOverlay(
        updateItem = existing,
        onDismiss = onDismiss,
        onDelete = { onDelete(EditingItem.QuestPersonal(it)) },
        onAdd = { onSave(EditingItem.QuestPersonal(it), existing != null) }
      )
    }
  }
}