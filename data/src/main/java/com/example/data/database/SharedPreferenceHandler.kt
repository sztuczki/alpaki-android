package com.example.data.database

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferenceHandler @Inject constructor(
    private val preferences: SharedPreferences
) {
    fun putString(key: String, value: String) =
        preferences.edit().putString(key, value).apply()

    fun getString(key: String) = preferences.getString(key, "")

    fun clear() = preferences.edit().clear().apply()
}