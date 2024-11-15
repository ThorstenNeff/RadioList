package com.tneff.radiochallenge.stationlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tneff.radiochallenge.stations.RadioStation
import com.tneff.radiochallenge.stations.RadioStationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RadioStationListViewModel : ViewModel() {

    private val radioStationRepository: RadioStationRepository = RadioStationRepository()

    private val _radioStations = MutableStateFlow<List<RadioStation>>(emptyList())
    val radioStations: StateFlow<List<RadioStation>> get() = _radioStations

    init {
        loadRadioStations()
    }

    private fun loadRadioStations() {
        viewModelScope.launch {
            // Simulating data fetching
            _radioStations.value = radioStationRepository.getRadioStations()
        }
    }
}