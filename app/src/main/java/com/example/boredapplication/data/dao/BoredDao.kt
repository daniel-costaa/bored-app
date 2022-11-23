package com.example.boredapplication.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.boredapplication.data.models.BoredActivityEntity

@Dao
interface BoredDao {
    @Query("SELECT * FROM activity_table")
    fun getAll(): List<BoredActivityEntity>
}