package com.github.luecy1.colabunofficial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel


class EventListViewModel : ViewModel() {

    private val eventRepository = EventListRepository()

    private val _eventLiveData = MediatorLiveData<List<EventListItem>>()

    val eventLiveData: LiveData<List<EventListItem>> = _eventLiveData


    fun loadData() {
        val eventList = eventRepository.getEventList()

        val list = mutableListOf<EventListItem>()

        for (event in eventList) {
            val eventListItem = EventListItem(event.title)
            list.add(eventListItem)
        }

        _eventLiveData.postValue(list)
    }
}
