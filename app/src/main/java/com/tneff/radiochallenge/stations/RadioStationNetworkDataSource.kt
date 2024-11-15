package com.tneff.radiochallenge.stations

import com.tneff.radiochallenge.stations.network.RadioStationApiService
import com.tneff.radiochallenge.stations.network.RetrofitClient

class RadioStationNetworkDataSource {

    private val apiService: RadioStationApiService = RetrofitClient.apiService


    suspend fun getRadioStations(): List<RadioStation> {
        return apiService.getRadioStations()
//        return listOf(
//            RadioStation("1", "Radio One", "http://radioone.com"),
//            RadioStation("2", "Classic FM", "http://classicfm.com"),
//            RadioStation("3", "Jazz Vibes", "http://jazzvibes.com"),
//            RadioStation("4", "Pop Hits", "http://pophits.com")
//        )
    }
}