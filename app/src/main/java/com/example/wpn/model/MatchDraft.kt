package com.example.wpn.model

import java.time.LocalDateTime

data class MatchDraft(
  val playedAt: LocalDateTime,
  val hardScoring: Boolean,
  val dlcIds: List<Long>,
  val quests: List<QuestSlotDraft>,
  val players: List<PlayerDraft>,
)

data class QuestSlotDraft(val questId: Long, val position: Int)

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

// refers to the quest by SLOT position, because the slot row has no id yet
data class QuestResultDraft(val questPosition: Int, val playerPosition: Int)
