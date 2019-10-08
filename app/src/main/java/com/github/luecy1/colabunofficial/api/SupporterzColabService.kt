package com.github.luecy1.colabunofficial.api

import com.github.luecy1.colabunofficial.model.Json
import retrofit2.Call
import retrofit2.http.GET

interface SupporterzColabService {

    @GET("api/v1/event/")
    fun eventList(): Call<Json>

}