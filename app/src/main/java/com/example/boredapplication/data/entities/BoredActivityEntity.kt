package com.example.boredapplication.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.boredapplication.data.models.ActivityStatus

@Entity(tableName = "activity_table")
data class BoredActivityEntity(
    @PrimaryKey
    val key: String,
    @ColumnInfo
    val accessibility: Double,
    @ColumnInfo
    val activity: String,
    @ColumnInfo
    val link: String,
    @ColumnInfo
    val participants: Int,
    @ColumnInfo
    val price: Double,
    @ColumnInfo
    val type: String,
    @ColumnInfo
    val status: ActivityStatus,
    @ColumnInfo (name = "time_spent")
    val timeSpent: Long
)