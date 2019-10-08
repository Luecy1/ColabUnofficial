package com.github.luecy1.colabunofficial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel


class EventListViewModel : ViewModel() {

    private val eventRepository = EventListRepository()

    private val _eventLiveData = MediatorLiveData<List<EventListItem>>()

    val eventLiveData: LiveData<List<EventListItem>> = _eventLiveData

    private val eventListHolder = mutableListOf<EventListItem>()

    fun loadData() {
        val eventList = eventRepository.getEventList()

        eventListHolder += eventList.map { it.toEventListItem() }

        _eventLiveData.postValue(eventListHolder)
    }
}
