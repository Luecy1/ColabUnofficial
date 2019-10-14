package com.github.luecy1.colabunofficial.di

import com.github.luecy1.colabunofficial.EventListRepository
import com.github.luecy1.colabunofficial.EventListViewModel
import com.github.luecy1.colabunofficial.api.factoryService
import org.koin.dsl.module

val supporterzColabModule = module {

    single { factoryService() }

    factory { EventListRepository(get()) }

    factory { EventListViewModel(get()) }
}