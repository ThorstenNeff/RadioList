package com.tneff.radiochallenge.stations

class RadioStationNetworkDataSource {
    suspend fun getRadioStations(): List<RadioStation> {
        return listOf(
            RadioStation("1", "Radio One", "http://radioone.com"),
            RadioStation("2", "Classic FM", "http://classicfm.com"),
            RadioStation("3", "Jazz Vibes", "http://jazzvibes.com"),
            RadioStation("4", "Pop Hits", "http://pophits.com")
        )
    }
}