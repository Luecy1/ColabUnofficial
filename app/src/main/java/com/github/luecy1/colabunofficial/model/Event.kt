package com.github.luecy1.colabunofficial.model

data class Event(
    val eventId: Int,
    val title: String,
    val catch: String,
    val description: String,
    val eventUrl: String,
    val hashTag: String,
    val startedAt: String,
    val endedAt: String,
    val limit: Int,
    val eventType: String,
    val series: Series,
    val address: String,
    val place: String,
    val lat: String,
    val lon: String,
    val ownerId: String,
    val ownerNickname: String,
    val ownerDisplayName: String,
    val accepted: Int,
    val waiting: Int,
    val updatedAt: String
)

data class Series(
    val id: Int,
    val title: String,
    val url: String
)