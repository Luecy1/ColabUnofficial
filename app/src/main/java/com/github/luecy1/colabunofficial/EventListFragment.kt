package com.github.luecy1.colabunofficial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.event_list_fragment.*


class EventListFragment : Fragment() {

    companion object {
        fun newInstance() = EventListFragment()
        val TAG: String = EventListFragment::class.java.simpleName
    }

    private lateinit var viewModel: EventListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.event_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EventListViewModel::class.java)

        val groupAdapter = GroupAdapter<GroupieViewHolder>()

        eventList.adapter = groupAdapter

        val itemList = listOf(
            EventListItem("ああああ"),
            EventListItem("いいいい"),
            EventListItem("うううう"),
            EventListItem("ええええ"),
            EventListItem("おおおお")
        ).toMutableList()

        groupAdapter.update(
            itemList
        )

        groupAdapter.setOnItemClickListener { _, _ ->
            itemList.add(EventListItem("おおおお"))

            groupAdapter.update(itemList)
        }
    }

}
