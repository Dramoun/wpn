package com.example.wpn.ui.map

import java.time.LocalDateTime

data class MatchDraft(
  val playedAt: LocalDateTime,
  val hardScoring: Boolean,
  val dlcIds: List<Long>,              // picked from the DLC lookup
  val quests: List<QuestSlotDraft>,    // the match quests, by slot
  val players: List<PlayerDraft>,
)

data class QuestSlotDraft(
  val questId: Long,                   // id from matchQuestsTable
  val position: Int,                   // slot 1, 2, 3
)

data class PlayerDraft(
  val playerId: Long,
  val totalBirdScore: Int,
  val totalEggCount: Int,
  val totalGatheredFood: Int,
  val totalTuckedCards: Int,
  val totalBirdCount: Int,
  val totalPersonalQuests: Int,
  val totalMatchQuests: Int,
  val tagIds: List<Long>,
  val personalQuestIds: List<Long>,
  val questResults: List<QuestResultDraft>,
)

data class QuestResultDraft(
  val questPosition: Int,              // which slot (not an id)
  val playerPosition: Int,             // how this player placed on it
)