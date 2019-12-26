package com.github.luecy1.colabunofficial.ui

import androidx.paging.DataSource
import com.github.luecy1.colabunofficial.repository.EventListRepository
import kotlinx.coroutines.CoroutineScope

class EventDataSourceFactory(
    eventRepository: EventListRepository,
    coroutineScope: CoroutineScope
) : DataSource.Factory<Int, EventModel>() {

    private val source = EventDataSource(coroutineScope, eventRepository)

    override fun create(): DataSource<Int, EventModel> {
        return source
    }
}