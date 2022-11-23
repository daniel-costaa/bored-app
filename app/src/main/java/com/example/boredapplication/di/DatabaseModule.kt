package com.example.boredapplication.di

import android.content.Context
import androidx.room.Room
import com.example.boredapplication.data.datasources.BoredDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single { provideDb(androidApplication()) }
    factory { provideDao(get()) }
}

fun provideDb(context: Context) = Room.databaseBuilder(
    context,
    BoredDatabase::class.java,
    "bored-db"
).build()

fun provideDao(db: BoredDatabase) = db.userDao()