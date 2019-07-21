package com.tappli.bustimetable.domain

data class BusSchedule(
    val busStopId: Int,
    val lineId: Int,
    val hours: Int,
    val minutes: Int,
    val isWeekDay: Boolean,
    val destination: Destination
)
