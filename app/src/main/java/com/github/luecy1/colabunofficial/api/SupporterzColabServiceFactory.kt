package com.github.luecy1.colabunofficial.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


fun supporterzColabServiceFactory(): SupporterzColabService {

    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://supporterzcolab.com")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    return retrofit.create<SupporterzColabService>(SupporterzColabService::class.java)
}