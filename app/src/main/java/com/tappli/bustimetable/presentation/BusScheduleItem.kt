package com.tappli.bustimetable.presentation

import com.tappli.bustimetable.R
import com.tappli.bustimetable.domain.BusSchedule
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.view_bus_schedule.view.*

class BusScheduleItem(val schedule: BusSchedule) : Item() {

    override fun getLayout(): Int = R.layout.view_bus_schedule

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.busScheduleTextView.text =
            String.format("%02d:%02d", schedule.hours, schedule.minutes)
    }
}