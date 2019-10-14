package com.github.luecy1.colabunofficial.api

import com.github.luecy1.colabunofficial.model.SupporterzColabResponce
import retrofit2.http.GET

interface SupporterzColabService {

    @GET("api/v1/event/")
    suspend fun eventList(): SupporterzColabResponce

}