package com.tneff.radiochallenge.stations

import com.tneff.radiochallenge.stations.network.data.RadioStationDetails

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

    suspend fun getStationDetails(radioId: String): RadioStationDetails? {
        val stationDetail = localDataSource.getRadioStationDetail(radioId)
        return stationDetail ?: run {
             refreshDetails(radioId)
        }
    }

    suspend fun refreshDetails(radioId: String): RadioStationDetails? {
        val stationDetail = networkDataSource.getRadioStationDetail(radioId)
        stationDetail?.let { localDataSource.storeStationDetail(it) }
        return stationDetail
    }

}