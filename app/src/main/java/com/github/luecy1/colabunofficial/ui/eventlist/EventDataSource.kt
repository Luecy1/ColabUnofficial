package com.github.luecy1.colabunofficial.ui.eventlist

import androidx.paging.PositionalDataSource
import com.github.luecy1.colabunofficial.model.SearchCondition
import com.github.luecy1.colabunofficial.repository.EventListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class EventDataSource(
    private val scope: CoroutineScope,
    private val repository: EventListRepository,
    private val searchCondition: SearchCondition = defaultCondition()
) : PositionalDataSource<EventModel>() {

    override fun invalidate() {
        super.invalidate()
        scope.cancel()
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<EventModel>) {

        scope.launch {
            val items = repository.getEventList(
                params = searchCondition.toMap(),
                start = 1,
                count = params.requestedLoadSize
            )


            val eventListModel = items.events.map { it.toEventModel() }

            callback.onResult(eventListModel, 0, items.resultsAvailable)
        }
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<EventModel>) {
        scope.launch {

            val items = repository.getEventList(
                params = searchCondition.toMap(),
                start = params.startPosition,
                count = params.loadSize
            )

            val eventListModel = items.events.map { it.toEventModel() }

            callback.onResult(eventListModel)
        }
    }
}

fun defaultCondition(): SearchCondition {
    return SearchCondition(
        keyword = "Kotlin"
    )
}
