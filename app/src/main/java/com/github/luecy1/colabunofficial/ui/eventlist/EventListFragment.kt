package com.github.luecy1.colabunofficial.ui.eventlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.github.luecy1.colabunofficial.R
import com.github.luecy1.colabunofficial.databinding.EventListFragmentBinding
import com.github.luecy1.colabunofficial.model.SearchCondition
import com.wada811.databinding.dataBinding
import kotlinx.android.synthetic.main.event_list_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class EventListFragment : Fragment() {

    private val viewModel: EventListViewModel by viewModel()

    private val binding: EventListFragmentBinding by dataBinding(R.layout.event_list_fragment)

    val adapter = EventListAdapter()

    companion object {
        fun newInstance() = EventListFragment()

        val TAG: String = EventListFragment::class.java.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.viewmodel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        eventList.adapter = adapter

        viewModel.repos.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)

            viewModel.loading.postValue(false)
        })

    }

    fun search(searchCondition: SearchCondition) {

        viewModel.loading.value = true

        viewModel.changeSearchCondition(searchCondition)

        viewModel.repos.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)

            viewModel.loading.postValue(false)
        })
    }

}
