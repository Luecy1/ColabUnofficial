package com.github.luecy1.colabunofficial.di

import com.github.luecy1.colabunofficial.repository.EventListRepository
import com.github.luecy1.colabunofficial.ui.EventListViewModel
import com.github.luecy1.colabunofficial.api.supporterzColabServiceFactory
import org.koin.dsl.module

val supporterzColabModule = module {

    single { supporterzColabServiceFactory() }

    factory { EventListRepository(get()) }

    factory { EventListViewModel(get()) }
}