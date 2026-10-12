package com.example.wpn.model

import java.time.LocalDateTime

data class Player(val id: Long, val name: String, val shortName: String, val joinedAt: LocalDateTime)
data class Tag(val id: Long, val name: String, val description: String)
data class Dlc(val id: Long, val name: String, val description: String)
data class Quest(val id: Long, val name: String, val description: String)
