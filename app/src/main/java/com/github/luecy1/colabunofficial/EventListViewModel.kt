package com.github.luecy1.colabunofficial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class EventListViewModel(
    private val eventRepository: EventListRepository
) : ViewModel() {

    private val _eventLiveData = MediatorLiveData<List<EventListItem>>()

    val eventLiveData: LiveData<List<EventListItem>> = _eventLiveData

    private val eventListHolder = mutableListOf<EventListItem>()

    fun loadData() {

        viewModelScope.launch {
            val eventList = eventRepository.getEventList()

            eventListHolder += eventList.map { it.toEventListItem() }

            _eventLiveData.postValue(eventListHolder)

        }
    }
}
