package com.github.luecy1.colabunofficial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.luecy1.colabunofficial.databinding.EventCardItemBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.databinding.BindableItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val groupAdapter = GroupAdapter<GroupieViewHolder>()

        eventList.adapter = groupAdapter

        val itemList = listOf(
            TextItem("ああああ"),
            TextItem("いいいい"),
            TextItem("うううう"),
            TextItem("ええええ"),
            TextItem("おおおお")
        ).toMutableList()

        groupAdapter.update(
            itemList
        )

        groupAdapter.setOnItemClickListener { item, view ->
            itemList.add(TextItem("おおおお"))

            groupAdapter.update(itemList)
        }

    }
}

class TextItem(val text: String) : BindableItem<EventCardItemBinding>() {
    override fun getLayout() = R.layout.event_card_item

    override fun bind(binding: EventCardItemBinding, position: Int) {
        binding.title.text = text
        binding.catchId.text = "最前線のデータサイエンティストに学ぶ実践型勉強会"
        binding.description.text = "サポーターズが贈るエンジニア勉強会。今回のテーマは「今更聞けない機械学習の基礎と応用」。"
    }
}