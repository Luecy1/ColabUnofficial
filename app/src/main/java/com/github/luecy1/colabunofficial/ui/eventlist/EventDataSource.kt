package com.github.luecy1.colabunofficial.ui.eventlist

import androidx.paging.ItemKeyedDataSource
import com.github.luecy1.colabunofficial.model.SearchCondition
import com.github.luecy1.colabunofficial.repository.EventListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class EventDataSource(
    private val scope: CoroutineScope,
    private val repository: EventListRepository,
    private val searchCondition: SearchCondition = defaultCondition()
) : ItemKeyedDataSource<Int, EventModel>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<EventModel>
    ) {

        scope.launch {
            val items = repository.getEventList(
                params = searchCondition.toMap(),
                start = 1,
                count = params.requestedLoadSize
            )

            val eventListModel = items.map { it.toEventModel() }

            callback.onResult(eventListModel)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<EventModel>) {
        scope.launch {

            val nextKey = params.key + params.requestedLoadSize

            val items = repository.getEventList(
                params = searchCondition.toMap(),
                start = nextKey,
                count = params.requestedLoadSize
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

fun defaultCondition(): SearchCondition {
    return SearchCondition(
        keyword = "Kotlin"
    )
}
