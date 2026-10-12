package com.example.wpn.model

import java.time.LocalDateTime

data class Match(
  val id: Long,
  val playedAt: LocalDateTime,
  val hardScoring: Boolean,                 // plain data point, no logic attached
  val dlcs: List<Dlc>,
  val quests: List<MatchQuestSlot>,         // the quests in play, by slot
  val players: List<PlayerResult>,
) {
  // derived, never stored; ties produce several winners
  val winners: List<PlayerResult>
    get() {
      val top = players.maxOfOrNull { it.totalBirdScore } ?: return emptyList()
      return players.filter { it.totalBirdScore == top }
    }
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
  val quest: Quest,          // resolved from the slot, UI never sees slot ids
  val slot: Int,             // questPosition
  val playerPosition: Int,   // ties allowed (same value for several players)
)

data class PlayerStats(
  val games: Int,
  val wins: Int,
  val averageScore: Double,
  val highScore: Int,
  val lowScore: Int,
  val lastPlayedAt: LocalDateTime?,
)
