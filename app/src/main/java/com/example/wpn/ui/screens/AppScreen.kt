package com.example.wpn.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.wpn.preprocesses.EditingItem
import com.example.wpn.preprocesses.rememberAppUiState
import com.example.wpn.ui.components.AppFloatingButton
import com.example.wpn.model.AppPage
import com.example.wpn.model.CommonCrudItemData
import com.example.wpn.model.PlayerItemData
import com.example.wpn.ui.navigation.AppDrawer
import com.example.wpn.ui.navigation.AppTopBar
import com.example.wpn.ui.overlay.AddSheet
import com.example.wpn.ui.theme.AppTheme

@Composable
fun AppScreen() {
  val ui = rememberAppUiState()
  val dlcList = remember {
    mutableStateListOf<CommonCrudItemData>()
  }
  val tagList = remember {
    mutableStateListOf<CommonCrudItemData>()
  }
  val questMatchList = remember {
    mutableStateListOf<CommonCrudItemData>()
  }
  val questPersonalList = remember {
    mutableStateListOf<CommonCrudItemData>()
  }

  val playerList = remember {
    mutableStateListOf<PlayerItemData>()
  }

  val showFab = when (ui.currentPage) {
    AppPage.HOME,
    AppPage.QUESTS_MATCH -> false
    else -> true
  }

  AppTheme(
    darkTheme = ui.darkTheme
  ) {
    AppDrawer(
      currentPage = ui.currentPage,
      onPageSelected = { ui.currentPage = it }
    ) { onMenuClick ->
      Scaffold(
        floatingActionButton = {
          if (showFab) {
            AppFloatingButton(onClick = ui::openAdd)
          }
        },
        topBar = {
          if (ui.currentPage != AppPage.HOME) {
          AppTopBar(
            page = ui.currentPage,
            onMenuClick = onMenuClick,
            playerName = playerList.find {
              it.id == ui.selectedPlayerId}?.name
          )}
        }
      ) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
          BaseScreen(
            currentPage = ui.currentPage,
            dlcList = dlcList,
            tagList = tagList,
            questMatchList = questMatchList,
            questPersonalList = questPersonalList,
            playerList = playerList,
            onDlcClick= { item -> ui.openEdit(EditingItem.DLC(item)) },
            onTagClick= { item -> ui.openEdit(EditingItem.Tag(item)) },
            onQuestMatchClick= { item -> ui.openEdit(EditingItem.QuestMatch(item)) },
            onQuestPersonalClick= { item -> ui.openEdit(EditingItem.QuestPersonal(item)) },
            onPlayerClick = { player ->
              ui.selectedPlayerId = player.id
              ui.currentPage = AppPage.PLAYER_DETAILS
            }
          )

          if (ui.showAddSheet) {
            AddSheet(
              currentPage = ui.currentPage,
              editingItem = ui.editingItem,
              onDismiss = ui::closeSheet,
              onSave = { item, isUpdate ->
                when (item) {
                  is EditingItem.DLC -> {
                    if (isUpdate) {
                      val index = dlcList.indexOfFirst {
                        it.id == item.item.id
                      }

                      if (index != -1) {
                        dlcList[index] = item.item
                      }
                    } else {
                      dlcList.add(item.item)
                    }
                  }

                  is EditingItem.Tag -> {
                    if (isUpdate) {
                      val index = tagList.indexOfFirst {
                        it.id == item.item.id
                      }

                      if (index != -1) {
                        tagList[index] = item.item
                      }
                    } else {
                      tagList.add(item.item)
                    }
                  }

                  is EditingItem.QuestMatch -> {
                    if (isUpdate) {
                      val index = questMatchList.indexOfFirst {
                        it.id == item.item.id
                      }

                      if (index != -1) {
                        questMatchList[index] = item.item
                      }
                    } else {
                      questMatchList.add(item.item)
                    }
                  }

                  is EditingItem.QuestPersonal -> {
                    if (isUpdate) {
                      val index = questPersonalList.indexOfFirst {
                        it.id == item.item.id
                      }

                      if (index != -1) {
                        questPersonalList[index] = item.item
                      }
                    } else {
                      questPersonalList.add(item.item)
                    }
                  }

                  is EditingItem.Player -> {
                    if (isUpdate) {
                      val index = playerList.indexOfFirst {
                        it.id == item.item.id
                      }

                      if (index != -1) {
                        playerList[index] = item.item
                      }
                    } else {
                      playerList.add(item.item)
                    }
                  }
                  EditingItem.None -> {}
                  else -> {}
                }
                ui.closeSheet()
              },
              onDelete = { item ->
                when (item) {
                  is EditingItem.Tag -> {
                    val index = tagList.indexOfFirst {
                      it.id == item.item.id
                    }

                    if (index != -1) {
                      tagList.removeAt(index)
                    }
                  }

                  is EditingItem.DLC -> {
                    val index = dlcList.indexOfFirst {
                      it.id == item.item.id
                    }

                    if (index != -1) {
                      dlcList.removeAt(index)
                    }
                  }

                  is EditingItem.QuestMatch -> {
                    val index = questMatchList.indexOfFirst {
                      it.id == item.item.id
                    }

                    if (index != -1) {
                      questMatchList.removeAt(index)
                    }
                  }

                  is EditingItem.QuestPersonal -> {
                    val index = questPersonalList.indexOfFirst {
                      it.id == item.item.id
                    }

                    if (index != -1) {
                      questPersonalList.removeAt(index)
                    }
                  }
                  EditingItem.None -> {}
                  else -> {}
                }
                ui.closeSheet()
              }
            )
          }
        }
      }
    }
  }
}