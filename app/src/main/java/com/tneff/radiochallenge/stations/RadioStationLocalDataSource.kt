package com.tneff.radiochallenge.stations

import com.tneff.radiochallenge.stations.network.data.RadioStationDetails


class RadioStationLocalDataSource {

    // TODO: Replace with Room
    fun getRadioStations(): List<RadioStation> = stations

    fun storeStations(stations: List<RadioStation>) {
        RadioStationLocalDataSource.stations = stations
    }

    fun storeStationDetail(stationDetails: RadioStationDetails) {
        radioStationDetails[stationDetails.id] = stationDetails
    }

    fun getRadioStationDetail(radioId: String): RadioStationDetails? {
        return radioStationDetails[radioId]
    }

    companion object {
        // TODO: Replace with Singleton in Dependency injection
        private var stations = listOf<RadioStation>()
        private var radioStationDetails = mutableMapOf<String, RadioStationDetails>()
    }
}