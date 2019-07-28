package com.tappli.bustimetable.presentation

import com.tappli.bustimetable.R
import com.tappli.bustimetable.domain.BusStop
import com.tappli.bustimetable.domain.Destination
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.view_bus_stop.view.*

class BusStopItem(
    private val busStop: BusStop,
    private val destination: Destination
) : Item(getItemId(busStop, destination)) {
    var onClick: (busStop: BusStop, destination: Destination) -> Unit = { _, _ -> }

    override fun getLayout(): Int = R.layout.view_bus_stop

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.busStopNameView.text = busStop.name
        viewHolder.itemView.setOnClickListener { onClick(busStop, destination) }
    }
}

private fun getItemId(busStop: BusStop, destination: Destination): Long {
    return busStop.id.value * when (destination) {
        Destination.ToHigasimurayama -> -1
        Destination.ToAkitsu -> 1
    }.toLong()
}
