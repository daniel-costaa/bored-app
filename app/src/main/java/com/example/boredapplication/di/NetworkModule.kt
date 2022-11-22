package com.example.boredapplication.di

import com.example.boredapplication.data.datasources.BoredApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

fun provideOkHttpClient(): OkHttpClient = OkHttpClient().newBuilder().build()

fun boredApi(retrofit: Retrofit): BoredApi = retrofit.create(BoredApi::class.java)

private const val BASE_URL = "http://www.boredapi.com"