package com.tneff.radiochallenge.stations


class RadioStationLocalDataSource {

    private var stations = listOf<RadioStation>()

    // TODO: Replace with Room
    suspend fun getRadioStations(): List<RadioStation> = stations

    fun storeStations(stations: List<RadioStation>) {
        this.stations = stations
    }

    fun getStation(stationId: String): RadioStation? = stations.find {
        it.id == stationId
    }
}