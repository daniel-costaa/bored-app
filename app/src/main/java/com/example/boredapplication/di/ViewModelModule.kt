package com.example.boredapplication.di

import com.example.boredapplication.ui.BoredViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { BoredViewModel(get()) }
}