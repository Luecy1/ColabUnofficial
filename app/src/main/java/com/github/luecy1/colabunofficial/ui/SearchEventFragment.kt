package com.github.luecy1.colabunofficial.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.luecy1.colabunofficial.R

class SearchEventFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_event, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = SearchEventFragment()
    }
}
