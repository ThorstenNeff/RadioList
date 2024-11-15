package com.tneff.radiochallenge.stations


class RadioStationLocalDataSource {

    private val stations = listOf(
        RadioStation("1", "Radio One", "http://radioone.com"),
        RadioStation("2", "Classic FM", "http://classicfm.com"),
        RadioStation("3", "Jazz Vibes", "http://jazzvibes.com"),
        RadioStation("4", "Pop Hits", "http://pophits.com")
    )

    // TODO: Replace with Room
    suspend fun getRadioStations(): List<RadioStation> = stations

    @Suppress("UNUSED_PARAMETER")
    fun storeStations(stations: List<RadioStation>) {
        // TODO: Implement
    }

    fun getStation(stationId: String): RadioStation? = stations.find {
        it.id == stationId
    }
}