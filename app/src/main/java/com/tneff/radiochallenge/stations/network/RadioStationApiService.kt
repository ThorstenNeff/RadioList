package com.tneff.radiochallenge.stations.network

import com.tneff.radiochallenge.stations.network.data.Detail
import com.tneff.radiochallenge.stations.network.data.DetailResult
import com.tneff.radiochallenge.stations.network.data.StationResult
import retrofit2.http.GET
import retrofit2.http.Query

interface RadioStationApiService {

    @GET("stations/list-by-system-name?systemName=STATIONS_TOP&count=100")
    suspend fun getRadioStations(): StationResult

    @GET("stations/details")
    suspend fun getStationDetails(
        @Query("stationIds") stationId: String
    ): List<Detail>
}