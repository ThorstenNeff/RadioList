package com.tneff.radiochallenge.stationdetails

import androidx.lifecycle.ViewModel
import com.tneff.radiochallenge.stations.RadioStation
import com.tneff.radiochallenge.stations.RadioStationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RadioStationDetailViewModel : ViewModel() {

    private val radioStationRepository: RadioStationRepository = RadioStationRepository()

    private val _radioStation = MutableStateFlow<RadioStation?>(null)
    val radioStation: StateFlow<RadioStation?> get() = _radioStation

    suspend fun loadStation(radioId: String) {
        _radioStation.value = radioStationRepository.getStation(radioId)
    }
}