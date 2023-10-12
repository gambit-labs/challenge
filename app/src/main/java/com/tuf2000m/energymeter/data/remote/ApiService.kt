package com.tuf2000m.energymeter.data.remote

import com.tuf2000m.energymeter.data.model.meterdata.MeterData
import com.tuf2000m.energymeter.data.model.recent.RecentData
import retrofit2.http.GET

interface ApiService {
    @GET("meterData")
    suspend fun timeStamps(): MeterData

    @GET("recentData")
    suspend fun recent(): RecentData
}