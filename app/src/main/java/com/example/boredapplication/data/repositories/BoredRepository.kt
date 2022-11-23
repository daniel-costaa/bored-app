package com.example.boredapplication.data.repositories

import com.example.boredapplication.data.datasources.BoredApi
import com.example.boredapplication.data.models.ActivityTypes
import com.example.boredapplication.utils.toUiActivity

class BoredRepository(private val remoteDataSource: BoredApi) {
    suspend fun getRandomActivity(type: ActivityTypes?) =
        remoteDataSource.getRandomEvent(type?.name?.lowercase()).toUiActivity()
}
