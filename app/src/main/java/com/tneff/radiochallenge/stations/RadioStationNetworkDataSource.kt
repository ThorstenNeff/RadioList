package com.tneff.radiochallenge.stations

import com.tneff.radiochallenge.stations.network.RadioStationApiService
import com.tneff.radiochallenge.stations.network.RetrofitClient
import com.tneff.radiochallenge.stations.network.data.Detail
import com.tneff.radiochallenge.stations.network.data.DetailResult
import com.tneff.radiochallenge.stations.network.data.Playable
import com.tneff.radiochallenge.stations.network.data.RadioStationDetails

class RadioStationNetworkDataSource {

    private val apiService: RadioStationApiService = RetrofitClient.apiService


    suspend fun getRadioStations(): List<RadioStation> {
        return mapPlayablesToRadioStations(apiService.getRadioStations().playables)
    }

    suspend fun getRadioStationDetail(radioId: String): RadioStationDetails? {
        return mapDetailResultToRadioStationDetails(apiService.getStationDetails(radioId))
    }

    private fun mapDetailResultToRadioStationDetails(
        stationDetails: List<Detail>
    ): RadioStationDetails? {
        val details = stationDetails.firstOrNull()
        return details?.let {
            RadioStationDetails(
                id = it.id,
                name = it.name,
                city = it.city,
                country = it.country,
                genres = it.genres,
                url = it.logo300x300,
                description = it.description,
            )
        }
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