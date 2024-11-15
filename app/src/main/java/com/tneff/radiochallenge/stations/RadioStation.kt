package com.tneff.radiochallenge.stations

data class RadioStation(
    val id: String,
    val name: String,
    val city: String = "",
    val country: String = "",
    val genres: List<String> = listOf(),
    val url: String
)

