package com.github.luecy1.colabunofficial.di

import com.github.luecy1.colabunofficial.api.supporterzColabAPIFactory
import com.github.luecy1.colabunofficial.repository.EventListRepository
import com.github.luecy1.colabunofficial.ui.eventlist.EventListViewModel
import org.koin.dsl.module

val supporterzColabModule = module {

    single { supporterzColabAPIFactory() }

    factory { EventListRepository(get()) }

    factory {
        EventListViewModel(
            get()
        )
    }
}