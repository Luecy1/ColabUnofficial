package com.github.luecy1.colabunofficial.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.github.luecy1.colabunofficial.R
import com.google.android.material.snackbar.Snackbar
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.event_list_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class EventListFragment : Fragment() {

    private val viewModel: EventListViewModel by viewModel()

    companion object {
        fun newInstance() = EventListFragment()
        val TAG: String = EventListFragment::class.java.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.event_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val groupAdapter = GroupAdapter<GroupieViewHolder>()

        eventList.adapter = groupAdapter

        viewModel.eventLiveData.observe(viewLifecycleOwner, Observer { eventList ->
            groupAdapter.update(eventList)
        })

        viewModel.message.observe(viewLifecycleOwner, Observer {
            Snackbar.make(requireView(), it, Snackbar.LENGTH_LONG).show()
        })

        viewModel.loadData()
    }

}
