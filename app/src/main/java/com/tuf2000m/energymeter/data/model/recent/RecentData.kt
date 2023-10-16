package com.tuf2000m.energymeter.data.model.recent

data class RecentData(
    val recentList: List<RecentList>
){
    data class RecentList(
        val guid: String,
        val timeStamp: String
    )
}