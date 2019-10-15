package com.github.luecy1.colabunofficial.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.luecy1.colabunofficial.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.event_list_fragment.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val eventListFragment = EventListFragment.newInstance()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view, eventListFragment, EventListFragment.TAG)
                .commit()
        }

        setSupportActionBar(toolbar)
    }
}
