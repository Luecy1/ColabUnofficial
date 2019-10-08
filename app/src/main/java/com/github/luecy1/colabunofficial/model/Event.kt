package com.github.luecy1.colabunofficial.model

import com.squareup.moshi.Json

data class Event(

    @Json(name = "event_id")
    val eventId: Int,

    val title: String,

    val catch: String,

    val description: String,

    @Json(name = "event_url")
    val eventUrl: String,

    @Json(name = "hash_tag")
    val hashTag: String,

    @Json(name = "started_at")
    val startedAt: String,

    @Json(name = "ended_at")
    val endedAt: String,

    val limit: Int?,

    @Json(name = "event_type")
    val eventType: String,

    val series: Series,

    val address: String,

    val place: String,

    val lat: String?,

    val lon: String?,

    @Json(name = "owner_id")
    val ownerId: String,

    @Json(name = "owner_nickname")
    val ownerNickname: String,

    @Json(name = "owner_display_name")
    val ownerDisplayName: String,

    val accepted: Int,

    val waiting: Int,

    @Json(name = "updated_at")
    val updatedAt: String
)

data class Series(
    val id: Int,
    val title: String,
    val url: String
)