package com.tneff.radiochallenge.stations


class RadioStationLocalDataSource {

    // TODO: Replace with Room
    fun getRadioStations(): List<RadioStation> = stations

    fun storeStations(stations: List<RadioStation>) {
        // TODO: Replace with Singleton in Dependency injection
        RadioStationLocalDataSource.stations = stations
    }

    fun getStation(stationId: String): RadioStation? {
        return stations.find {
            it.id == stationId
        }
    }

    companion object {
        private var stations = listOf<RadioStation>()
    }
}