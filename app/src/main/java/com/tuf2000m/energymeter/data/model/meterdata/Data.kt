package com.tuf2000m.energymeter.data.model.meterdata

data class Data(
    val category: String,
    val unit: String,
    val value: Double,
    val variableName: String
)