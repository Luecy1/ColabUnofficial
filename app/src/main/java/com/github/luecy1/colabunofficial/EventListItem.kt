package com.github.luecy1.colabunofficial

import com.github.luecy1.colabunofficial.databinding.EventCardItemBinding
import com.xwray.groupie.databinding.BindableItem


class EventListItem(private val text: String) : BindableItem<EventCardItemBinding>() {
    override fun getLayout() = R.layout.event_card_item

    override fun bind(binding: EventCardItemBinding, position: Int) {
        binding.title.text = text
        binding.catchId.text = "最前線のデータサイエンティストに学ぶ実践型勉強会"
        binding.description.text = "サポーターズが贈るエンジニア勉強会。今回のテーマは「今更聞けない機械学習の基礎と応用」。"
        binding.date.text = "02/22"
        binding.acceptedAndLimit.text = "50/50"
    }
}