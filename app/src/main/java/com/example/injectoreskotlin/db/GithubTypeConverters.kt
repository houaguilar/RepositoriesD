package com.example.injectoreskotlin.db

import android.util.Log
import androidx.room.TypeConverter
import java.lang.NumberFormatException

object GithubTypeConverters {
    @TypeConverter
    @JvmStatic
    fun stringToIntList(data: String?): List<Int>? {
        return data?.let {
            it.split(",").map {
                try {
                    it.toInt()
                } catch (e: NumberFormatException){
                    Log.d("TAG1", "stringToIntList: No puede convertir a numero")
                    null
                }
            }.filterNotNull()
        }
    }

    @TypeConverter
    @JvmStatic
    fun intListToString(ints: List<Int>?): String? {
        return ints?.joinToString { "," }
    }
}