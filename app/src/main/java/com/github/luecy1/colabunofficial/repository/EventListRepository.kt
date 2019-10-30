package com.github.luecy1.colabunofficial.repository

import androidx.lifecycle.LiveData
import com.github.luecy1.colabunofficial.api.SupporterzColabAPI
import com.github.luecy1.colabunofficial.db.EventDao
import com.github.luecy1.colabunofficial.model.Event

class EventListRepository(
    private val api: SupporterzColabAPI
) {

    suspend fun getEventList(): List<Event> = api.eventList().events

}

class EventListDb(
    private val eventDao: EventDao
) {
    suspend fun insert(event: com.github.luecy1.colabunofficial.db.model.Event) {
        eventDao.insert(event)
    }

    val getDbData: LiveData<List<com.github.luecy1.colabunofficial.db.model.Event>> =
        eventDao.getEvent()
}