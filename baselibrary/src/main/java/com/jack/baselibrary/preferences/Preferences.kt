package com.jack.baselibrary.preferences


import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.lang.reflect.Type

abstract class Preferences {

    protected val gson: Gson by lazy {
        GsonBuilder().create()
    }

    abstract var sharedPreferences: SharedPreferences

    fun getString(key: String, value: String = ""): String = sharedPreferences.getString(key, value) ?: ""

    fun putString(key: String, value: String) = sharedPreferences.edit { putString(key, value) }

    fun getFloat(key: String, value: Float = 0f): Float = sharedPreferences.getFloat(key, value)

    fun putFloat(key: String, value: Float) = sharedPreferences.edit { putFloat(key, value) }

    fun getBoolean(key: String, value: Boolean = false): Boolean = sharedPreferences.getBoolean(key, value)

    fun putBoolean(key: String, value: Boolean) =
        sharedPreferences.edit { putBoolean(key, value) }

    fun getLong(key: String, value: Long = 0L): Long = sharedPreferences.getLong(key, value)

    fun putLong(key: String, value: Long) = sharedPreferences.edit { putLong(key, value) }

    fun getInt(key: String, value: Int = 0): Int = sharedPreferences.getInt(key, value)

    fun putInt(key: String, value: Int) = sharedPreferences.edit { putInt(key, value) }

    fun getObjectByClass(key: String, classOfType: Class<*>): Any? = gson.fromJson(getString(key), classOfType)

    fun getObjectByType(key: String, type: Type): Any? = gson.fromJson(getString(key), type)

    fun putObject(key: String, value: Any?) =
        sharedPreferences.edit { putString(key, gson.toJson(value)) }

    fun clear() = sharedPreferences.edit { clear() }

}