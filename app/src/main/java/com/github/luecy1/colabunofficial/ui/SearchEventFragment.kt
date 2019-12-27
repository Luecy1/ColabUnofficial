package com.github.luecy1.colabunofficial.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.luecy1.colabunofficial.R
import com.github.luecy1.colabunofficial.databinding.FragmentSearchEventBinding
import com.github.luecy1.colabunofficial.model.SearchCondition
import com.wada811.databinding.dataBinding

class SearchEventFragment(
    val changeTabLayout: ChangeTabLayoutListener
) : Fragment() {

    private val binding: FragmentSearchEventBinding by dataBinding(R.layout.fragment_search_event)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.searchButton.setOnClickListener {
            val condition = SearchCondition("")
            changeTabLayout.changeTab(0)
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(
            changeTabLayout: ChangeTabLayoutListener
        ) = SearchEventFragment(changeTabLayout)
    }
}
