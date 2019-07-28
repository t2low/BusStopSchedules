package com.tappli.bustimetable.presentation

import com.tappli.bustimetable.R
import com.tappli.bustimetable.domain.BusSchedule
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.view_bus_schedule.view.*

data class BusScheduleItem(private val schedules: List<BusSchedule>) : Item() {

    override fun getLayout(): Int = R.layout.view_bus_schedule

    override fun bind(viewHolder: ViewHolder, position: Int) {
        val hour = schedules.first().hours
        val minutes = schedules.map { it.minutes }
        viewHolder.itemView.scheduleHourTextView.text = String.format("%2d", hour)
        viewHolder.itemView.scheduleMinutesTextView.text =
            minutes.joinToString("  ") { String.format("%02d", it) }
    }
}