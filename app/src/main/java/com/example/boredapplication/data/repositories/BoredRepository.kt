package com.example.boredapplication.data.repositories

import com.example.boredapplication.data.dao.BoredDao
import com.example.boredapplication.data.datasources.BoredApi
import com.example.boredapplication.data.entities.BoredActivityExtraData
import com.example.boredapplication.data.models.ActivityStatus
import com.example.boredapplication.data.models.ActivityTypes
import com.example.boredapplication.data.models.BoredActivityUi
import com.example.boredapplication.utils.toEntityActivity
import com.example.boredapplication.utils.toUiActivity

class BoredRepository(
    private val remoteDataSource: BoredApi,
    private val localDataSource: BoredDao
) {
    suspend fun getRandomActivity(type: ActivityTypes?) =
        remoteDataSource
            .getRandomEvent(type?.name?.lowercase())
            .toUiActivity()

    suspend fun saveActivity(uiActivity: BoredActivityUi) {
        localDataSource.saveActivity(uiActivity.toEntityActivity())
    }

    suspend fun updateExtraData(key: String, status: ActivityStatus, timeSpent: Long) {
        localDataSource.updateExtraActivityDate(BoredActivityExtraData(key, status, timeSpent))
    }
}
