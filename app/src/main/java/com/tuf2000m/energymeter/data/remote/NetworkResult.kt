package com.tuf2000m.energymeter.data.remote

sealed class NetworkResult<T> {
    data class Loading<T>(val isLoading: Boolean) : NetworkResult<T>()
    data class Success<T>(val data: T,val apiName: String = "") : NetworkResult<T>()
    data class Failure<T>(val errorMessage: String) : NetworkResult<T>()
}