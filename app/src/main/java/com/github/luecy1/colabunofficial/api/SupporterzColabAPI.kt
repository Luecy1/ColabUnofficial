package com.github.luecy1.colabunofficial.api

import com.github.luecy1.colabunofficial.model.SupporterzColabResponce
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SupporterzColabAPI {

    @GET("api/v1/event/")
    suspend fun eventList(
        @QueryMap params: Map<String, String>?,
        @Query("start") start: Int,
        @Query("order") order: Int,
        @Query("count") count: Int
    ): SupporterzColabResponce

}