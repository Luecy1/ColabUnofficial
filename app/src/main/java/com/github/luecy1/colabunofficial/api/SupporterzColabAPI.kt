package com.github.luecy1.colabunofficial.api

import com.github.luecy1.colabunofficial.model.SupporterzColabResponce
import retrofit2.http.GET
import retrofit2.http.Query

interface SupporterzColabAPI {

    @GET("api/v1/event/")
    suspend fun eventList(
        @Query("start") start: Int = 1
    ): SupporterzColabResponce

}