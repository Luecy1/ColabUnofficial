package com.github.luecy1.colabunofficial.ui.eventlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.github.luecy1.colabunofficial.model.Event
import com.github.luecy1.colabunofficial.model.SearchCondition
import com.github.luecy1.colabunofficial.repository.EventListRepository


class EventListViewModel(
    val eventRepository: EventListRepository
) : ViewModel() {

    @Suppress("PrivatePropertyName")
    private val TAG: String = EventListViewModel::class.java.simpleName

    private val _eventLiveData = MediatorLiveData<List<Event>>()
    val eventLiveData: LiveData<List<Event>> = _eventLiveData

    var repos: LiveData<PagedList<EventModel>>

    private val _message = MediatorLiveData<String>()
    val message: LiveData<String> = _message

    val loading = MediatorLiveData<Boolean>().apply {
        setValue(true)
    }

    init {
        val factory =
            EventDataSourceFactory(
                eventRepository,
                viewModelScope,
                defaultCondition()
            )
        repos = LivePagedListBuilder(factory, 10).build()
    }

    fun changeSearchCondition(searchCondition: SearchCondition) {
        val factory =
            EventDataSourceFactory(
                eventRepository,
                viewModelScope,
                searchCondition
            )
        repos = LivePagedListBuilder(factory, 10).build()
    }

}
