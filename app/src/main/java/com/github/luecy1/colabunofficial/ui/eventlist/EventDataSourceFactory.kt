package com.github.luecy1.colabunofficial.ui.eventlist

import androidx.paging.DataSource
import com.github.luecy1.colabunofficial.model.SearchCondition
import com.github.luecy1.colabunofficial.repository.EventListRepository
import kotlinx.coroutines.CoroutineScope

class EventDataSourceFactory(
    eventRepository: EventListRepository,
    coroutineScope: CoroutineScope,
    searchCondition: SearchCondition
) : DataSource.Factory<Int, EventModel>() {

    private val source =
        EventDataSource(
            coroutineScope,
            eventRepository,
            searchCondition
        )

    override fun create(): DataSource<Int, EventModel> {
        return source
    }
}