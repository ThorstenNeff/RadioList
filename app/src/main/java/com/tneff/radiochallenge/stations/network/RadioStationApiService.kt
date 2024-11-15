package com.tneff.radiochallenge.stations.network

import com.tneff.radiochallenge.stations.network.data.StationResult
import retrofit2.http.GET

interface RadioStationApiService {

    @GET("stations/list-by-system-name?systemName=STATIONS_TOP&count=100")
    suspend fun getRadioStations(): StationResult
}