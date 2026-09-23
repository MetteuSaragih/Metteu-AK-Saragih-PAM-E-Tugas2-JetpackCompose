package com.example.androiduiwithjetpackcompose

import android.content.Context

object UserPrefs {

    private const val PREF_NAME = "user_prefs"

    private const val KEY_FIRST_NAME = "firstName"
    private const val KEY_LAST_NAME = "lastName"
    private const val KEY_USERNAME = "username"
    private const val KEY_EMAIL = "email"
    private const val KEY_PASSWORD = "password"
    private const val KEY_PHONE = "phoneNumber"
    private const val KEY_ADDRESS = "address"
    private const val KEY_BIRTH_DATE = "birthDate"
    private const val KEY_IS_REGISTERED = "isRegistered"

    fun save(context: Context, user: UserData) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        prefs.edit().apply {
            putString(KEY_FIRST_NAME, user.firstName)
            putString(KEY_LAST_NAME, user.lastName)
            putString(KEY_USERNAME, user.username)
            putString(KEY_EMAIL, user.email)
            putString(KEY_PASSWORD, user.password)
            putString(KEY_PHONE, user.phoneNumber)
            putString(KEY_ADDRESS, user.address)
            putString(KEY_BIRTH_DATE, user.birthDate)
            putBoolean(KEY_IS_REGISTERED, true)
            apply()
        }
    }

    fun load(context: Context): UserData? {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        if (!prefs.getBoolean(KEY_IS_REGISTERED, false)) return null

        return UserData(
            firstName = prefs.getString(KEY_FIRST_NAME, "") ?: "",
            lastName = prefs.getString(KEY_LAST_NAME, "") ?: "",
            username = prefs.getString(KEY_USERNAME, "") ?: "",
            email = prefs.getString(KEY_EMAIL, "") ?: "",
            password = prefs.getString(KEY_PASSWORD, "") ?: "",
            phoneNumber = prefs.getString(KEY_PHONE, "") ?: "",
            address = prefs.getString(KEY_ADDRESS, "") ?: "",
            birthDate = prefs.getString(KEY_BIRTH_DATE, "") ?: ""
        )
    }
}