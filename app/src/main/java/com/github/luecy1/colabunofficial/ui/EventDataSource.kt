package com.github.luecy1.colabunofficial.ui

import androidx.paging.ItemKeyedDataSource
import com.github.luecy1.colabunofficial.repository.EventListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class EventDataSource(
    private val scope: CoroutineScope,
    private val repository: EventListRepository
) : ItemKeyedDataSource<Int, EventModel>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<EventModel>
    ) {

        scope.launch {
            val items = repository.getEventList(
                start = params.requestedLoadSize
            )

            val eventListModel = items.map { it.toEventModel() }

            callback.onResult(eventListModel)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<EventModel>) {
        scope.launch {
            val items = repository.getEventList(
                start = params.requestedLoadSize
            )

            val eventListModel = items.map { it.toEventModel() }

            callback.onResult(eventListModel)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<EventModel>) {
        // ignore
    }

    override fun getKey(item: EventModel): Int {
        return 0
    }

    override fun invalidate() {
        super.invalidate()
        scope.cancel()
    }
}