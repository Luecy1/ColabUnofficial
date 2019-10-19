package com.github.luecy1.colabunofficial.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.luecy1.colabunofficial.model.Event
import com.github.luecy1.colabunofficial.model.Failure
import com.github.luecy1.colabunofficial.model.Success
import com.github.luecy1.colabunofficial.repository.EventListRepository
import kotlinx.coroutines.launch


class EventListViewModel(
    private val eventRepository: EventListRepository
) : ViewModel() {

    private val _eventLiveData = MediatorLiveData<List<EventListItem>>()
    val eventLiveData: LiveData<List<EventListItem>> = _eventLiveData

    private val eventListHolder = mutableListOf<EventListItem>()

    private val _message = MediatorLiveData<String>()
    val message: LiveData<String> = _message

    fun loadData() {

        viewModelScope.launch {

            when (val eventList = eventRepository.getEventList()) {

                is Success<*> -> {
                    @Suppress("UNCHECKED_CAST")
                    eventListHolder += ((eventList.value) as List<Event>).map { it.toEventListItem() }
                    _eventLiveData.postValue(eventListHolder)
                }

                is Failure -> _message.postValue(eventList.message)
            }
        }
    }
}
