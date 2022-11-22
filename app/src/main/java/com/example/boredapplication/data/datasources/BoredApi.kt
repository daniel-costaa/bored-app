package com.example.boredapplication.data.datasources

import com.example.boredapplication.data.models.BoredActivity
import retrofit2.http.GET
import retrofit2.http.Query

interface BoredApi {
    @GET("/api/activity/")
    suspend fun getRandomEvent(@Query("type") type: String?): BoredActivity
}