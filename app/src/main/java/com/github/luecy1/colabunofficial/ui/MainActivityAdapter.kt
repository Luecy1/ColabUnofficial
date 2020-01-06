package com.github.luecy1.colabunofficial.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.github.luecy1.colabunofficial.model.SearchCondition
import com.github.luecy1.colabunofficial.ui.eventlist.EventListFragment

class MainActivityAdapter(
    fm: FragmentManager,
    private val search: SearchListener
) : FragmentPagerAdapter(
    fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    private val tabTitles = arrayOf("Event", "Search")

    private var eventListFragment: EventListFragment? = null

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> EventListFragment.newInstance().also {
                eventListFragment = it
            }
            1 -> {
                SearchEventFragment.newInstance(search)
            }
            else -> throw IllegalAccessException("Unexpected position->$position")
        }
    }

    override fun getCount(): Int {
        return tabTitles.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }

    fun search(searchCondition: SearchCondition) {
        eventListFragment?.search(searchCondition)
    }
}