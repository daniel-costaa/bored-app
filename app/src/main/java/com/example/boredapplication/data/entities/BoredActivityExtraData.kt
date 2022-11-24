package com.example.boredapplication.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.boredapplication.data.models.ActivityStatus

@Entity
data class BoredActivityExtraData(
    @PrimaryKey
    val key: String,
    @ColumnInfo
    val status: ActivityStatus,
    @ColumnInfo(name = "time_spent")
    val timeSpent: Long
)