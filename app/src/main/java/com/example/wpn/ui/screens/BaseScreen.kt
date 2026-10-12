package com.example.wpn.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.wpn.ui.map.AppPage
import com.example.wpn.ui.map.CommonCrudItemData
import com.example.wpn.ui.pages.BaseLookupPage


@Composable
fun BaseScreen(
  modifier: Modifier = Modifier,
  currentPage: AppPage,
  dlcList: List<CommonCrudItemData>,
  tagList: List<CommonCrudItemData>,
  questMatchList: List<CommonCrudItemData>,
  questPersonalList: List<CommonCrudItemData>,
  onDlcClick: (CommonCrudItemData) -> Unit = {},
  onTagClick: (CommonCrudItemData) -> Unit = {},
  onQuestMatchClick: (CommonCrudItemData) -> Unit = {},
  onQuestPersonalClick: (CommonCrudItemData) -> Unit = {},
) {
  when (currentPage) {
    AppPage.MATCH_LIST -> null
    AppPage.HOME ->
      HomeScreen(
        modifier = modifier
      )
    AppPage.PLAYER_LIST -> null
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