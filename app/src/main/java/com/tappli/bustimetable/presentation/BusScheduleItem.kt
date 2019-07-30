package com.tappli.bustimetable.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.tappli.bustimetable.R
import com.tappli.bustimetable.domain.BusSchedule
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.view_bus_schedule.view.*
import kotlinx.android.synthetic.main.view_minutes_item.view.*

data class BusScheduleItem(private val schedules: List<BusSchedule>) : Item() {

    override fun getLayout(): Int = R.layout.view_bus_schedule

    override fun bind(viewHolder: ViewHolder, position: Int) {
        val hour = schedules.first().hours
        viewHolder.itemView.scheduleHourTextView.text = String.format("%02d", hour)
        val inflater = LayoutInflater.from(viewHolder.itemView.context)
        schedules
            .map {
                inflater.inflate(R.layout.view_minutes_item, null).apply {
                    minutesButton.text = String.format("%02d", it.minutes)
                    minutesButton.setOnClickListener {
                        // TODO:
                    }
                }
            }
            .forEach {
                viewHolder.itemView.minutesItemContainer.addView(it)
            }
    }
}