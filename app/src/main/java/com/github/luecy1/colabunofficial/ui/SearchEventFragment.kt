package com.github.luecy1.colabunofficial.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.luecy1.colabunofficial.R
import com.github.luecy1.colabunofficial.databinding.FragmentSearchEventBinding
import com.github.luecy1.colabunofficial.model.SearchCondition
import com.wada811.databinding.dataBinding
import java.util.*


class SearchEventFragment(
    private val search: SearchListener
) : Fragment() {

    private val binding: FragmentSearchEventBinding by dataBinding(R.layout.fragment_search_event)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.searchButton.setOnClickListener {
            val condition = SearchCondition("")
            search.changeTab(condition)
        }

        binding.date.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                onDateClick()
            }
        }

        return binding.root
    }

    fun onDateClick() {

        // 日付情報の初期設定
        val calendar: Calendar = Calendar.getInstance()
        val year: Int = calendar.get(Calendar.YEAR)
        val monthOfYear: Int = calendar.get(Calendar.MONTH)
        val dayOfMonth: Int = calendar.get(Calendar.DAY_OF_MONTH)


        var datePickerDialog = DatePickerDialog(
            requireActivity(),
            null,
            year,
            monthOfYear,
            dayOfMonth
        )

        datePickerDialog.show()
    }

    companion object {
        @JvmStatic
        fun newInstance(
            search: SearchListener
        ) = SearchEventFragment(search)
    }
}
