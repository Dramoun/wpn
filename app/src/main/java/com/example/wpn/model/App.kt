package com.example.wpn.model

import java.time.LocalDateTime

enum class AppPage(val label: String) {
  HOME("Home"),
  PLAYER_LIST("Players"),
  PLAYER_DETAILS("Player details"),
  MATCH_LIST("Matches"),
  MATCH_EDIT("Edit match"),
  TAGS("Tags"),
  DLCS("DLCs"),
  QUESTS_PERSONAL("Player quests"),
  QUESTS_MATCH("Match quests")
}

data class CommonCrudItemData(
  val id: Long?,
  val name: String,
  val description: String?
)

data class PlayerItemData(
  val id: Long?,
  val name: String,
  val shortName: String,
  val joinedAt: LocalDateTime,
  val lastPlayed: LocalDateTime?,
  val totalGames: Int?,
  val totalWins: Int?,
  val averageScore: Float?,
  val highScore: Int?,
  val lowScore: Int?
)

data class PlayerMatchItemData(
  val id: Long,
  val playerId: String,
  val matchId: String,
  val totalBirdScore: Int,
  val totalEggCount: Int,
  val totalGatheredFood: Int,
  val totalTuckedCards: Int,
  val totalBirdCount: Int,
  val totalPersonalQuests: Int,
  val totalMatchQuests: Int,
  val totalScore: Int,
  val tags: MutableList<String>,
  val playerPersonalQuests: MutableList<String>,
  val playerMatchQuests: MutableMap<Int, Int>
)

data class MatchData(
  val id: Long?,
  val playedAt: LocalDateTime?,
  val hardScoring: Boolean = false,
  val dlcs: List<Long>,
  val quests: Map<Int, Long>,
  val playerDataList: List<PlayerMatchItemData>
)