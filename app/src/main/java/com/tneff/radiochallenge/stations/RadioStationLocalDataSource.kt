package com.tneff.radiochallenge.stations

class RadioStationLocalDataSource {

    // TODO: Replace with Room
    suspend fun getRadioStations(): List<RadioStation> {
        return listOf(
            RadioStation("1", "Radio One", "http://radioone.com"),
            RadioStation("2", "Classic FM", "http://classicfm.com"),
            RadioStation("3", "Jazz Vibes", "http://jazzvibes.com"),
            RadioStation("4", "Pop Hits", "http://pophits.com")
        )
    }

    fun storeStations(stations: List<RadioStation>) {
        // TODO: Implement
    }
}