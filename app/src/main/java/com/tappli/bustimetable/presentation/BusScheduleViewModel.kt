package com.tappli.bustimetable.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.tappli.bustimetable.data.BusScheduleRepositoryImpl
import com.tappli.bustimetable.domain.BusSchedule
import com.tappli.bustimetable.domain.BusStopId
import com.tappli.bustimetable.domain.Destination

class BusScheduleViewModel(application: Application) : AndroidViewModel(application) {

    private val busScheduleRepositoryImpl = BusScheduleRepositoryImpl(application.applicationContext)

    fun getWeekdayBusSchedule(busStopId: BusStopId, destination: Destination): List<BusSchedule> {
        return when (destination) {
            Destination.ToHigasimurayama -> busScheduleRepositoryImpl.weekdayInbound
            Destination.ToAkitsu -> busScheduleRepositoryImpl.weekdayOutbound
        }
    }
}