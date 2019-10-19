package com.github.luecy1.colabunofficial.repository

import com.github.luecy1.colabunofficial.api.SupporterzColabService
import com.github.luecy1.colabunofficial.model.Response
import com.github.luecy1.colabunofficial.model.Failure
import com.github.luecy1.colabunofficial.model.Success

class EventListRepository(
    private val service: SupporterzColabService
) {

    suspend fun getEventList(): Response {

        val response = service.eventList()

        if (response.isSuccessful) {
            return Success(response.body()!!.events)
        }

        return Failure("Failure response")
    }

}