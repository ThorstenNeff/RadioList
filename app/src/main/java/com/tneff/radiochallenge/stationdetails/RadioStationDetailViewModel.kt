package com.tneff.radiochallenge.stationdetails

import androidx.lifecycle.ViewModel
import com.tneff.radiochallenge.stations.RadioStation
import com.tneff.radiochallenge.stations.RadioStationRepository

class RadioStationDetailViewModel : ViewModel() {

    private val radioStationRepository: RadioStationRepository = RadioStationRepository()

    fun loadStation(radioId: String): RadioStation? {
        return radioStationRepository.getStation(radioId)
    }
}