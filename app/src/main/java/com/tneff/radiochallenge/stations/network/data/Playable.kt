package com.tneff.radiochallenge.stations.network.data

data class Playable (
    val id: String = "",
    val name: String = "",
    val city: String = "",
    val country: String = "",
    val genres: List<String> = listOf(),
    val logo300x300: String = "",
)