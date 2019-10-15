package com.github.luecy1.colabunofficial.ui

import com.github.luecy1.colabunofficial.R
import com.github.luecy1.colabunofficial.databinding.EventCardItemBinding
import com.github.luecy1.colabunofficial.model.Event
import com.github.luecy1.colabunofficial.util.toMMDD
import com.xwray.groupie.databinding.BindableItem

class EventListItem(
    private val text: String,
    private val catchId: String,
    private val description: String,
    private val date: String,
    private val acceptedAndLimit: String
) : BindableItem<EventCardItemBinding>() {
    override fun getLayout() = R.layout.event_card_item

    override fun bind(binding: EventCardItemBinding, position: Int) {
        binding.title.text = text
        binding.catchId.text = catchId
        binding.description.text = description
        binding.date.text = date
        binding.acceptedAndLimit.text = acceptedAndLimit
    }
}

fun Event.toEventListItem(): EventListItem {

    val date = this.startedAt.toMMDD()

    val accepted = "${this.accepted}/${this.limit}"

    return EventListItem(
        this.title,
        this.catch,
        this.description,
        date,
        accepted
    )
}