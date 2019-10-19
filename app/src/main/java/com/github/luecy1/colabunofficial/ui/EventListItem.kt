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

    val accepted = if (this.limit != null) {
        "${this.accepted}/${this.limit} 人"
    } else {
        "${this.accepted} 人"
    }

    val eraseHtml = this.description.eraseHtml()
    val description = if (eraseHtml.length > 150) {
        eraseHtml.take(150).toString() + "..."
    } else {
        eraseHtml.toString()
    }

    return EventListItem(
        this.title,
        this.catch,
        description,
        date,
        accepted
    )
}

private fun CharSequence.eraseHtml(): CharSequence = this
    .replace("</?[^>]+?>".toRegex(), "")
    .replace("\n", " ")