package com.tneff.radiochallenge.stations

class RadioStationRepository(
    private val networkDataSource: RadioStationNetworkDataSource = RadioStationNetworkDataSource(),
    private val localDataSource: RadioStationLocalDataSource = RadioStationLocalDataSource()
) {
    suspend fun getRadioStations(): List<RadioStation> {
        val stations = localDataSource.getRadioStations()
        return stations.ifEmpty {
            refresh()
        }
    }

    suspend fun refresh(): List<RadioStation> {
        val stations = networkDataSource.getRadioStations()
        localDataSource.storeStations(stations)
        return stations
    }

    fun getStation(radioId: String): RadioStation? {
        return localDataSource.getStation(radioId)
    }
}