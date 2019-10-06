package com.github.luecy1.colabunofficial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

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
    }
}
