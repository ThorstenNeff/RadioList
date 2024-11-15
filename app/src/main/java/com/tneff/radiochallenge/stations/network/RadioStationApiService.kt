package com.tneff.radiochallenge.stations.network

import com.tneff.radiochallenge.stations.RadioStation
import retrofit2.http.GET

interface RadioStationApiService {

    @GET("api/stations")
    suspend fun getRadioStations(): List<RadioStation>
}