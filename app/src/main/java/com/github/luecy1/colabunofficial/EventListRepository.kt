package com.github.luecy1.colabunofficial

import com.github.luecy1.colabunofficial.api.SupporterzColabService
import com.github.luecy1.colabunofficial.api.factoryService
import com.github.luecy1.colabunofficial.model.Event

class EventListRepository {

    private val service: SupporterzColabService = factoryService()

    suspend fun getEventList(): List<Event> = service.eventList().events

}