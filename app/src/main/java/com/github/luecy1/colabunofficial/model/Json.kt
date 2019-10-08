package com.github.luecy1.colabunofficial.model

import com.squareup.moshi.Json

data class Json(

    @Json(name = "results_returned")
    val resultsReturned: Int,

    @Json(name = "results_available")
    val resultsAvailable: Int,

    @Json(name = "results_start")
    val resultsStart: Int,

    val events: List<Event>
)