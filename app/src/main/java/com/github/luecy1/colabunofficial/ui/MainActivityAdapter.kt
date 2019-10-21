package com.github.luecy1.colabunofficial.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainActivityAdapter(
    fm: FragmentManager
) : FragmentPagerAdapter(
    fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    private val tabTitles = arrayOf("Event", "Search")

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> EventListFragment.newInstance()
            1 -> SearchEventFragment.newInstance()
            else -> throw IllegalAccessException("Unexpected position->$position")
        }
    }

    override fun getCount(): Int {
        return tabTitles.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }
}