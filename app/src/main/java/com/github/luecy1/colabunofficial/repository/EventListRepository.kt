package com.github.luecy1.colabunofficial.repository

import com.github.luecy1.colabunofficial.api.SupporterzColabAPI
import com.github.luecy1.colabunofficial.model.Event

class EventListRepository(
    private val api: SupporterzColabAPI
) {

    suspend fun getEventList(): List<Event> = api.eventList().events
}