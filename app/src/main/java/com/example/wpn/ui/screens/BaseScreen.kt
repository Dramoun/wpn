package com.example.wpn.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.wpn.model.AppPage
import com.example.wpn.model.CommonCrudItemData
import com.example.wpn.model.MatchData
import com.example.wpn.model.PlayerItemData
import com.example.wpn.ui.pages.BaseLookupPage
import com.example.wpn.ui.pages.HomeScreen
import com.example.wpn.ui.pages.MatchListPage
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
  matchesList: List<MatchData>,
  onDlcClick: (CommonCrudItemData) -> Unit,
  onTagClick: (CommonCrudItemData) -> Unit,
  onQuestMatchClick: (CommonCrudItemData) -> Unit,
  onQuestPersonalClick: (CommonCrudItemData) -> Unit,
  onPlayerClick: (PlayerItemData) -> Unit,
  onPlayerUpdateClick: (PlayerItemData) -> Unit,
  onDeletePlayerClick: (PlayerItemData) -> Unit,
  onMatchClick: (MatchData) -> Unit,
  getPlayerData: (id: Long) -> PlayerItemData,
  selectedPlayerData: PlayerItemData?
) {
  when (currentPage) {
    AppPage.MATCH_LIST ->
      MatchListPage(
        modifier = modifier,
        matchesList = matchesList,
        getPlayerData = getPlayerData,
        onMatchClick = onMatchClick
      )
    AppPage.MATCH_EDIT -> null
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