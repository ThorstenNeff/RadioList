package com.tneff.radiochallenge.stationdetails

import android.util.Log
import androidx.lifecycle.ViewModel
import com.tneff.radiochallenge.stations.RadioStation
import com.tneff.radiochallenge.stations.RadioStationRepository

class RadioStationDetailViewModel : ViewModel() {

    private val radioStationRepository: RadioStationRepository = RadioStationRepository()

    suspend fun loadStation(radioId: String): RadioStation? {
        Log.d("STATION","loadStation $radioId")
        return radioStationRepository.getStation(radioId)
    }
}