package com.tuf2000m.energymeter.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.tuf2000m.energymeter.data.model.auth.UserProfile
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPreferenceManager @Inject constructor(
    @ApplicationContext val context: Context
) {

    private val prefName = "user-pref"
    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

    fun saveUSer(user: UserProfile) {
        sharedPref.edit().putString("user", Gson().toJson(user)).apply()
    }

    fun getUser(): UserProfile? {
        val data = sharedPref.getString("user", null) ?: return null
        return Gson().fromJson(data, UserProfile::class.java)
    }

    fun clearData() {
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE).edit().clear().apply()
    }

}