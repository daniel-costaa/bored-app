package com.example.boredapplication.utils

import com.example.boredapplication.data.entities.BoredActivityEntity
import com.example.boredapplication.data.models.ActivityStatus
import com.example.boredapplication.data.models.BoredActivityDTO
import com.example.boredapplication.data.models.BoredActivityUi

fun BoredActivityDTO.toUiActivity() = BoredActivityUi(
    key = this.key,
    accessibility = this.accessibility,
    activity = this.activity,
    participants = this.participants,
    price = this.price,
    type = this.type,
    status = null,
    timeSpent = null
)

fun BoredActivityUi.toEntityActivity() =
    BoredActivityEntity(
        accessibility = this.accessibility,
        activity = this.activity,
        participants = this.participants,
        price = this.price,
        type = this.type,
        status = this.status ?: ActivityStatus.EMANDAMENTO,
        key = this.key,
        link = this.link,
        timeSpent = this.timeSpent ?: 0L
    )

