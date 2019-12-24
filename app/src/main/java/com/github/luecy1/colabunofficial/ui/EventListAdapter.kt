package com.github.luecy1.colabunofficial.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.luecy1.colabunofficial.databinding.EventCardItemBinding
import com.github.luecy1.colabunofficial.util.toMMDD

class EventListAdapter :
    PagedListAdapter<EventModel, EventListAdapter.BindingHolder>(RecyclerDiffCallback()) {

    private val TAG = javaClass.simpleName

    val eventModel: MutableList<EventModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = EventCardItemBinding.inflate(inflater)

        binding.root.layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, WRAP_CONTENT)

        return BindingHolder(binding)
    }


    override fun onBindViewHolder(holder: BindingHolder, position: Int) {

//        val event = eventModel[position]
        val event = getItem(position)
        holder.binding.viewmodel = event

        holder.binding.root.setOnClickListener {
            Log.d(TAG, "clicked! $it")
        }


        holder.binding.executePendingBindings()
    }


    class RecyclerDiffCallback : DiffUtil.ItemCallback<EventModel>() {

        override fun areItemsTheSame(oldItem: EventModel, newItem: EventModel): Boolean {
            return oldItem.item.title == newItem.item.title
        }

        override fun areContentsTheSame(oldItem: EventModel, newItem: EventModel): Boolean {
            return oldItem.item == newItem.item
        }
    }

    override fun submitList(pagedList: PagedList<EventModel>?) {

        Log.d(TAG, "hoge")

        super.submitList(pagedList)
    }

    class BindingHolder(var binding: EventCardItemBinding) : RecyclerView.ViewHolder(binding.root)

}

fun com.github.luecy1.colabunofficial.model.Event.toEventModel(): EventModel {


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

    return EventModel(
        Event(
            title = this.title,
            date = date,
            catchId = this.catch,
            description = description,
            acceptedAndLimit = accepted
        )
    )
}

private fun CharSequence.eraseHtml(): CharSequence = this
    .replace("</?[^>]+?>".toRegex(), "")
    .replace("\n", " ")