package com.tappli.bustimetable.presentation

import com.tappli.bustimetable.R
import com.tappli.bustimetable.domain.BusStop
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.view_bus_stop.view.*

class BusStopItem(private val busStop: BusStop) : Item(busStop.id.value.toLong()) {
    override fun getLayout(): Int = R.layout.view_bus_stop

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.busStopNameView.text = busStop.name
    }
}