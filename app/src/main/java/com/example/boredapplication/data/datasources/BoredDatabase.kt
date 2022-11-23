package com.example.boredapplication.data.datasources

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.boredapplication.data.dao.BoredDao
import com.example.boredapplication.data.models.BoredActivityEntity

@Database(entities = [BoredActivityEntity::class], version = 1)
abstract class BoredDatabase : RoomDatabase() {
    abstract fun userDao(): BoredDao
}