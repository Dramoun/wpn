package com.example.wpn.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.wpn.model.AppPage
import com.example.wpn.model.CommonCrudItemData
import com.example.wpn.model.PlayerItemData
import com.example.wpn.ui.pages.BaseLookupPage
import com.example.wpn.ui.pages.HomeScreen
import com.example.wpn.ui.pages.PlayerDetailsPage
import com.example.wpn.ui.pages.PlayerListPage


@Composable
fun BaseScreen(
  modifier: Modifier = Modifier,
  currentPage: AppPage,
  dlcList: List<CommonCrudItemData>,
  tagList: List<CommonCrudItemData>,
  questMatchList: List<CommonCrudItemData>,
  questPersonalList: List<CommonCrudItemData>,
  playerList: List<PlayerItemData>,
  onDlcClick: (CommonCrudItemData) -> Unit,
  onTagClick: (CommonCrudItemData) -> Unit,
  onQuestMatchClick: (CommonCrudItemData) -> Unit,
  onQuestPersonalClick: (CommonCrudItemData) -> Unit,
  onPlayerClick: (PlayerItemData) -> Unit,
  onPlayerUpdateClick: (PlayerItemData) -> Unit,
  onDeletePlayerClick: (PlayerItemData) -> Unit,
  selectedPlayerData: PlayerItemData?
) {
  when (currentPage) {
    AppPage.MATCH_LIST -> null
    AppPage.HOME ->
      HomeScreen(
        modifier = modifier
      )
    AppPage.PLAYER_LIST ->
      PlayerListPage(
        modifier = modifier,
        playerList = playerList,
        onPlayerClick = onPlayerClick
      )
    AppPage.PLAYER_DETAILS ->
      PlayerDetailsPage(
        playerInfo = selectedPlayerData!!,
        onUpdateClick = onPlayerUpdateClick,
        onDeleteClick = onDeletePlayerClick
      )
    AppPage.DLCS ->
      BaseLookupPage(
        modifier = modifier,
        itemList = dlcList,
        onItemClick = onDlcClick
      )
    AppPage.TAGS ->
      BaseLookupPage(
        modifier = modifier,
        itemList = tagList,
        onItemClick = onTagClick
      )
    AppPage.QUESTS_MATCH ->
      BaseLookupPage(
        modifier = modifier,
        itemList = questMatchList,
        onItemClick = onQuestMatchClick
      )
    AppPage.QUESTS_PERSONAL ->
      BaseLookupPage(
        modifier = modifier,
        itemList = questPersonalList,
        onItemClick = onQuestPersonalClick
      )
  }
}