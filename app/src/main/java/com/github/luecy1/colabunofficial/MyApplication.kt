package com.github.luecy1.colabunofficial

import android.app.Application
import com.github.luecy1.colabunofficial.di.supporterzColabModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@Suppress("unused")
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(supporterzColabModule)
        }
    }
}