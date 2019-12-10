package com.github.luecy1.colabunofficial.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.github.luecy1.colabunofficial.model.Event
import com.github.luecy1.colabunofficial.repository.EventListRepository
import kotlinx.coroutines.launch


class EventListViewModel(
    private val eventRepository: EventListRepository
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
        val factory = EventDataSourceFactory(eventRepository, viewModelScope)
        repos = LivePagedListBuilder(factory, 10).build()
    }

    fun loadData() = viewModelScope.launch {


        loading.value = true
        runCatching {
            eventRepository.getEventList(1)
        }.onSuccess {
            _eventLiveData.postValue(it)
            loading.value = false
        }.onFailure {
            _message.value = "Failure"

            loading.value = false
            Log.e(TAG, "Failure", it)
        }
    }
}
