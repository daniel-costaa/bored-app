package com.example.boredapplication.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Update
import com.example.boredapplication.data.entities.BoredActivityEntity
import com.example.boredapplication.data.entities.BoredActivityExtraData

@Dao
interface BoredDao {
    @Insert(onConflict = IGNORE)
    suspend fun saveActivity(activityEntity: BoredActivityEntity)

    @Update(entity = BoredActivityEntity::class)
    suspend fun updateExtraActivityDate(extraData: BoredActivityExtraData)
}