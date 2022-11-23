package com.example.boredapplication.utils

import com.example.boredapplication.data.models.BoredActivityDTO
import com.example.boredapplication.data.models.BoredActivityUi

fun BoredActivityDTO.toUiActivity() = BoredActivityUi(
    accessibility = this.accessibility,
    activity = this.activity,
    participants = this.participants,
    price = this.price,
    type = this.type
)

