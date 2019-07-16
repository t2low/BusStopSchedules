package com.tappli.bustimetable.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tappli.bustimetable.data.BusStopRepositoryImpl
import com.tappli.bustimetable.domain.BusStop
import com.tappli.bustimetable.domain.Destination

class BusStopViewModel(application: Application) : AndroidViewModel(application) {
    private val busStopRepository = BusStopRepositoryImpl()

    private val _busStopList = MutableLiveData<List<BusStop>>()

    val busStopList: LiveData<List<BusStop>>
        get() = _busStopList

    private var destination: Destination = Destination.ToAkitsu

    init {
        setDestination(Destination.ToAkitsu)
    }

    private fun setDestination(destination: Destination) {
        this.destination = destination
        _busStopList.value = when (destination) {
            Destination.ToHigasimurayama -> busStopRepository.getAll().reversed()
            Destination.ToAkitsu -> busStopRepository.getAll()
        }
    }

    fun toggleDestination() = when (destination) {
        Destination.ToHigasimurayama -> setDestination(Destination.ToAkitsu)
        Destination.ToAkitsu -> setDestination(Destination.ToHigasimurayama)
    }
}