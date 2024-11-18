package com.tneff.radiochallenge.stationdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tneff.radiochallenge.stations.RadioStationRepository
import com.tneff.radiochallenge.stations.network.data.RadioStationDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RadioStationDetailViewModel: ViewModel() {

    private val radioStationRepository: RadioStationRepository = RadioStationRepository()

    private val _stationDetails = MutableStateFlow<RadioStationDetails?>(null)
    val stationDetails: StateFlow<RadioStationDetails?> get() = _stationDetails

    fun loadRadioStations(id: String) {
        viewModelScope.launch {
            // Simulating data fetching
            _stationDetails.value = radioStationRepository.getStationDetails(id)
        }
    }
}