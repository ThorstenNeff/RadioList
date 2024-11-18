package com.tneff.radiochallenge.stations.network.data

data class RadioStationDetails(
    val id: String = "",
    val name: String = "",
    val city: String = "",
    val country: String = "",
    val genres: List<String> = listOf(),
    val url: String = "",

    val description: String = "",
)