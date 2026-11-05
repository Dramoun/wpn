package com.example.wpn.ui.helpers

import java.time.Duration
import java.time.LocalTime

fun minutesBetween(start: LocalTime, end: LocalTime): Int {
  val duration = Duration.between(start, end)
    .let { if (it.isNegative) it.plusDays(1) else it }
  return duration.toMinutes().toInt()
}