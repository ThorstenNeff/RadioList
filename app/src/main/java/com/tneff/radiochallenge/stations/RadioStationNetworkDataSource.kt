package com.tneff.radiochallenge.stations

import android.util.Log
import com.tneff.radiochallenge.stations.network.RadioStationApiService
import com.tneff.radiochallenge.stations.network.RetrofitClient
import com.tneff.radiochallenge.stations.network.data.Playable

class RadioStationNetworkDataSource {

    private val apiService: RadioStationApiService = RetrofitClient.apiService


    suspend fun getRadioStations(): List<RadioStation> {
        val stations = mapPlayablesToRadioStations(apiService.getRadioStations().playables)
        return stations
    }

    private fun mapPlayablesToRadioStations(playables: List<Playable>): List<RadioStation> {
        return playables.map { playable ->
            RadioStation(
                id = playable.id,
                name = playable.name,
                city = playable.city,
                country = playable.country,
                genres = playable.genres,
                url = playable.logo300x300 // Hier wird das Logo als URL verwendet, anpassen, falls ein Stream-URL benötigt wird
            )
        }
    }
}