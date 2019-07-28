package com.tappli.bustimetable.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.tappli.bustimetable.R
import com.tappli.bustimetable.domain.BusStop
import com.tappli.bustimetable.domain.BusStopId
import com.tappli.bustimetable.domain.Destination
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_bus_schedule.*

class BusScheduleActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context, busStop: BusStop, destination: Destination): Intent {
            return Intent(context, BusScheduleActivity::class.java).apply {
                putExtra(Parameter.BusStopId.name, busStop.id.value)
                putExtra(Parameter.Destination.name, destination)
            }
        }
    }

    private enum class Parameter {
        BusStopId,
        Destination
    }


    private lateinit var viewModel: BusScheduleViewModel
    private val adapter = GroupAdapter<ViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_schedule)

        val busStopId = BusStopId(intent.getIntExtra(Parameter.BusStopId.name, 0))
        val destination = intent.getSerializableExtra(Parameter.Destination.name) as Destination

        busScheduleListView.adapter = adapter

        viewModel = ViewModelProviders.of(this).get(BusScheduleViewModel::class.java)
        val items = viewModel.getWeekdayBusSchedule(busStopId, destination)
            .groupBy { it.hours }
            .map { BusScheduleItem(it.value) }
        adapter.update(items)
    }
}
