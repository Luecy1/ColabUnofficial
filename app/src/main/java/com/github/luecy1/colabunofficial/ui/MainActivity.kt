package com.github.luecy1.colabunofficial.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.luecy1.colabunofficial.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ChangeTabLayoutListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MainActivityAdapter(supportFragmentManager, this)

        viewPager.offscreenPageLimit = 2
        viewPager.adapter = adapter

        tabLayout.setupWithViewPager(viewPager)

        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_list_black_24dp)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_search_black_24dp)
    }

    override fun changeTab(item: Int) {
        viewPager.setCurrentItem(item, true)
    }
}
