package com.github.luecy1.colabunofficial.repository

import com.github.luecy1.colabunofficial.api.SupporterzColabAPI
import com.github.luecy1.colabunofficial.model.Event

class EventListRepository(
    private val api: SupporterzColabAPI
) {

    suspend fun getEventList(
        start: Int = 1,
        order: Int = 1,
        count: Int = 10
    ): List<Event> {
        return api.eventList(
            start = start,
            order = order,
            count = count
        ).events
    }
}