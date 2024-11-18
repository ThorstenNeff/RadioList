package com.tneff.radiochallenge.stations.network.data

data class Detail (
    val id: String = "",
    val name: String = "",
    val city: String = "",
    val country: String = "",
    val genres: List<String> = listOf(),
    val logo300x300: String = "",

    val description: String = "",
)