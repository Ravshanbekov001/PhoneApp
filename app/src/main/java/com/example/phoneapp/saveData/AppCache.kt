package com.example.phoneapp.saveData

import Models.Parameters
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object AppCache {
    private const val NAME = "toCache"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences


    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var objectString: ArrayList<Parameters>
        get() = gsonStringtoArray(preferences.getString("object", "[]")!!)
        set(value) = AppCache.preferences.edit {
            if (value != null) {
                it.putString("object", arrayToGsonString(value))
            }
        }

    private fun arrayToGsonString(arrayList: ArrayList<Parameters>): String {
        return Gson().toJson(arrayList)

    }

    private fun gsonStringtoArray(gsonString: String): ArrayList<Parameters> {
        val typeToken = object : TypeToken<ArrayList<Parameters>>() {}.type
        return Gson().fromJson(gsonString, typeToken)

    }

}