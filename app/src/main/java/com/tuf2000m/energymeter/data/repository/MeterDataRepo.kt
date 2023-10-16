package com.tuf2000m.energymeter.data.repository

import com.tuf2000m.energymeter.base.BaseRepository
import com.tuf2000m.energymeter.data.remote.ApiService
import javax.inject.Inject

class MeterDataRepo @Inject constructor(private val apiService: ApiService) : BaseRepository() {

    suspend fun getTimeStamps() = safeApiCall {
        // TODO: Pull individual timestamps when we have the right API in the backend service.
        //  For now pulling all three mock responses as time stamps from a Json free service.
        apiService.timeStamps()
    }

    suspend fun getRecents() = safeApiCall {
        apiService.recent()
    }
}

