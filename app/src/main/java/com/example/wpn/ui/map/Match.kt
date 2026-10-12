package com.example.wpn.ui.map

import java.time.LocalDateTime

data class Match(
  val id: Long,
  val playedAt: LocalDateTime,
  val hardScoring: Boolean,
  val dlcs: List<Dlc>,
  val quests: List<MatchQuestSlot>,      // the quests in play, by slot
  val players: List<PlayerResult>,
) {
  // derived, never stored (ties produce several winners)
  val winners: List<PlayerResult>
    get() = players.filter { it.totalBirdScore == players.maxOf { p -> p.totalBirdScore } }
}

data class MatchQuestSlot(val position: Int, val quest: Quest)

data class PlayerResult(
  val playerMatchId: Long,
  val player: Player,
  val totalBirdScore: Int,
  val totalEggCount: Int,
  val totalGatheredFood: Int,
  val totalTuckedCards: Int,
  val totalBirdCount: Int,
  val totalPersonalQuests: Int,
  val totalMatchQuests: Int,
  val tags: List<Tag>,
  val personalQuests: List<Quest>,
  val questResults: List<QuestResult>,
)

data class QuestResult(
  val quest: Quest,          // resolved from the slot, so the UI never sees ids
  val slot: Int,             // questPosition
  val playerPosition: Int,   // how this player placed on it
)