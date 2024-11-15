package com.tneff.radiochallenge.stations

import android.util.Log


class RadioStationLocalDataSource {

    // TODO: Replace with Room
    suspend fun getRadioStations(): List<RadioStation> = stations

    fun storeStations(stations: List<RadioStation>) {
        // TODO: Replace with Singleton in Dependency injection
        RadioStationLocalDataSource.stations = stations
    }

    fun getStation(stationId: String): RadioStation? {
        Log.d("STATION","get $stationId")
        Log.d("STATION","size ${stations.size}")
        return stations.find {
            it.id == stationId
        }
    }

    companion object {
        private var stations = listOf<RadioStation>()
    }
}