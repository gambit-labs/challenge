package com.tuf2000m.energymeter.data.model.meterdata

data class TimeStamp(
    val data: List<Data>,
    val guid: String,
    val timeStamp: String
)