package com.example.boredapplication

import android.app.Application
import com.example.boredapplication.di.databaseModule
import com.example.boredapplication.di.networkModule
import com.example.boredapplication.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(networkModule, repositoryModule, databaseModule)
        }
    }
}