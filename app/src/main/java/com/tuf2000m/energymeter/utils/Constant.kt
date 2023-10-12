package com.tuf2000m.energymeter.utils

import java.text.SimpleDateFormat
import java.util.TimeZone

object Constant {
    object API {
        const val BASE = "https://my-json-server.typicode.com/MinchalaVenkatSunil/demo/"
    }


    object TimeFormatter {
        fun convertUTCFormat(date: String): String? {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            inputFormat.timeZone = TimeZone.getTimeZone("UTC")
            val outputFormat = SimpleDateFormat("yyyy-MM-dd hh:mm a")
            // TODO: Need tweaks
            outputFormat.timeZone = TimeZone.getDefault()
            try {
                val parserDate = inputFormat.parse(date)
                return outputFormat.format(parserDate)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ""
        }
    }
}