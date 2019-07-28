package com.tappli.bustimetable.data

import android.content.Context
import com.tappli.bustimetable.domain.BusSchedule
import com.tappli.bustimetable.domain.Destination
import java.io.InputStreamReader
import kotlin.math.abs

class BusScheduleRepositoryImpl(private val context: Context) {
    companion object {
        private const val BusScheduleFileName = "time_table.csv"
    }

    private val busSchedules: List<BusSchedule>

    init {
        busSchedules = InputStreamReader(context.assets.open(BusScheduleFileName)).use {
            it.readLines().map { line ->
                val items = line.split(",")
                if (items.size != 3) return@map null
                val busStopId = items[0].toInt()
                val lineId = items[1].toInt()
                val time = items[2].split(":")
                val hours = time[0].toInt()
                val minutes = time[1].toInt()
                val isWeekDay = lineId in 200..400 // 土日のIDは200～
                val destination = if (busStopId > 0) Destination.ToAkitsu else Destination.ToHigasimurayama
                BusSchedule(abs(busStopId), lineId, hours, minutes, isWeekDay, destination)
            }.filterNotNull()
        }
    }

    val weekdaySchedules: List<BusSchedule> by lazy { busSchedules.filter { it.isWeekDay } }
    val holidaySchedules: List<BusSchedule> by lazy { busSchedules.filter { !it.isWeekDay } }
    val weekdayInbound: List<BusSchedule> by lazy { weekdaySchedules.filter { it.destination == Destination.ToHigasimurayama } }
    val weekdayOutbound: List<BusSchedule> by lazy { weekdaySchedules.filter { it.destination == Destination.ToAkitsu } }
    val holidayInbound: List<BusSchedule> by lazy { holidaySchedules.filter { it.destination == Destination.ToHigasimurayama } }
    val holidayOutbound: List<BusSchedule> by lazy { holidaySchedules.filter { it.destination == Destination.ToAkitsu } }
}