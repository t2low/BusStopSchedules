package com.tappli.bustimetable.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tappli.bustimetable.R
import com.tappli.bustimetable.domain.BusStop
import com.tappli.bustimetable.domain.Destination

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_schedule)

        val busStopId = intent.getIntExtra(Parameter.BusStopId.name, 0)
        val destination = intent.getSerializableExtra(Parameter.Destination.name) as Destination
    }
}
