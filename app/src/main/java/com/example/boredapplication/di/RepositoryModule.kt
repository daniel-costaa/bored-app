package com.example.boredapplication.di

import com.example.boredapplication.data.repositories.BoredRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { BoredRepository(get()) }
}
