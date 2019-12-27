package com.github.luecy1.colabunofficial.ui.eventlist

class EventModel(
    val item: Event
)

data class Event(
    val title: String,
    val date: String,
    val catchId: String,
    val description: String,
    val acceptedAndLimit: String
)