package com.example.boredapplication.data.models

data class BoredActivityUi(
    val key: String,
    val accessibility: Double,
    val activity: String,
    val participants: Int,
    val price: Double,
    val type: String,
    val status: ActivityStatus?,
    val timeSpent: Long?,
    val link: String = ""
)
