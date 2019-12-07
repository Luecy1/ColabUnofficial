package com.github.luecy1.colabunofficial.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.luecy1.colabunofficial.databinding.EventCardItemBinding
import com.github.luecy1.colabunofficial.util.toMMDD

class EventListAdapter : RecyclerView.Adapter<EventListAdapter.BindingHolder>() {

    val TAG = javaClass.simpleName

    val eventModel: MutableList<EventModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = EventCardItemBinding.inflate(inflater)

        binding.root.layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, WRAP_CONTENT)

        return BindingHolder(binding)
    }

    override fun getItemCount(): Int = eventModel.size

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {

        val event = eventModel[position]
        holder.binding.viewmodel = event

        holder.binding.root.setOnClickListener {
            Log.d(TAG, "clicked! $it")
        }


        holder.binding.executePendingBindings()
    }

    fun updateEventModels(newEventModel: List<EventModel>?) {
        if (newEventModel != null) {
            val diff = DiffUtil.calculateDiff(
                RecyclerDiffCallback(eventModel.toList(), newEventModel), true
            )
            eventModel.let {
                it.clear()
                it.addAll(newEventModel)
            }
            diff.dispatchUpdatesTo(this)
        }
    }

    class RecyclerDiffCallback(
        private val old: List<EventModel>,
        private val new: List<EventModel>
    ) :
        DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

            val oldItem = old[oldItemPosition]
            val newItem = new[newItemPosition]

            return oldItem == newItem
        }

        override fun getOldListSize(): Int = old.size

        override fun getNewListSize(): Int = new.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = old[oldItemPosition]
            val newItem = new[newItemPosition]

            return oldItem == newItem
        }
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