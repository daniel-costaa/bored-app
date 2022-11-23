package com.example.boredapplication.data.models

import com.squareup.moshi.Json

data class BoredActivityDTO(
    @Json(name = "accessibility")
    val accessibility: Double,
    @Json(name = "activity")
    val activity: String,
    @Json(name = "key")
    val key: String,
    @Json(name = "link")
    val link: String,
    @Json(name = "participants")
    val participants: Int,
    @Json(name = "price")
    val price: Double,
    @Json(name = "type")
    val type: String
)