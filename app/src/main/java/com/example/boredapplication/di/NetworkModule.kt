package com.example.boredapplication.di

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    factory { provideOkHttpClient() }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
     Retrofit.Builder()
        .baseUrl("http://www.boredapi.com")
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

fun provideOkHttpClient(): OkHttpClient = OkHttpClient().newBuilder().build()
