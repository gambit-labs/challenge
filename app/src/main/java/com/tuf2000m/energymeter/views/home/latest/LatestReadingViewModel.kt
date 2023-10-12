package com.tuf2000m.energymeter.views.home.latest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tuf2000m.energymeter.data.model.meterdata.Data
import com.tuf2000m.energymeter.data.model.meterdata.MeterData
import com.tuf2000m.energymeter.data.model.meterdata.TimeStamp
import com.tuf2000m.energymeter.data.model.recent.RecentData
import com.tuf2000m.energymeter.data.remote.NetworkResult
import com.tuf2000m.energymeter.data.repository.MeterDataRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LatestReadingViewModel @Inject constructor(
    private val meterDataRepo: MeterDataRepo,
) : ViewModel() {

    // LiveData to hold meter data
    private var _meterData = MutableLiveData<NetworkResult<MeterData>>()
    val meterData: LiveData<NetworkResult<MeterData>> = _meterData

    // LiveData to hold recent data
    private var _recentData = MutableLiveData<NetworkResult<RecentData>>()
    val recentData: LiveData<NetworkResult<RecentData>> = _recentData

    // LiveData to hold search data results
    private var _searchData = MutableLiveData<List<Data>>()
    val searchData: LiveData<List<Data>> = _searchData

    /**
     * Fetches timestamps for meter data.
     */
    fun getTimeStamps() {
        viewModelScope.launch {
            meterDataRepo.getTimeStamps().collect {
                _meterData.postValue(it)
            }
        }
    }

    /**
     * Fetches recent data.
     */
    fun getRecent() {
        viewModelScope.launch {
            meterDataRepo.getRecents().collect {
                _recentData.postValue(it)
            }
        }
    }

    /**
     * Searches for data based on the given query within provided timestamps.
     *
     * @param timeStamps List of timestamps to search in.
     * @param query The query to search for.
     */
    fun searchData(timeStamps: List<TimeStamp>, query: CharSequence?) {
        timeStamps.map { timeDto ->
            val dataList = timeDto.data.filter { dataDto ->
                dataDto.variableName.lowercase().contains(query.toString().lowercase())
            }
            _searchData.postValue(dataList)
        }
    }
}
