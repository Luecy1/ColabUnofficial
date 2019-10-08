package com.github.luecy1.colabunofficial

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.github.luecy1.colabunofficial.api.factoryService
import com.github.luecy1.colabunofficial.model.Json
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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


        val supporterzColabService = factoryService()
        supporterzColabService.eventList().enqueue(
            object : Callback<Json> {
                override fun onFailure(call: Call<Json>, t: Throwable) {
                    Log.e("TAG", "error -> ", t)
                }

                override fun onResponse(call: Call<Json>, response: Response<Json>) {
                    Log.d("TAG", response.message())
                    println(response.body())
                }
            }
        )
    }
}
