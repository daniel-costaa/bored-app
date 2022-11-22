package com.example.boredapplication.data.datasources

import com.example.boredapplication.data.models.BoredActivity
import retrofit2.http.GET

interface BoredApi {
    @GET("/api/activity/")
    suspend fun getRandomEvent(): BoredActivity
}