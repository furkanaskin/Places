package com.faskn.persistence.converters

import androidx.room.TypeConverter
import com.faskn.data.response.PhotosItem
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

/**
 * Created by Furkan on 18.07.2020
 */

object DataConverters {
    @TypeConverter
    @JvmStatic
    fun stringToList(data: String?): List<String>? {
        if (data == null) {
            return emptyList()
        }

        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter = moshi.adapter<List<String>>(type)
        return adapter.fromJson(data)
    }

    @TypeConverter
    @JvmStatic
    fun listToString(objects: List<String>): String {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter = moshi.adapter<List<String>>(type)
        return adapter.toJson(objects)
    }

    @TypeConverter
    @JvmStatic
    fun photosToList(data: String?): List<PhotosItem>? {
        if (data == null) {
            return emptyList()
        }

        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, PhotosItem::class.java)
        val adapter = moshi.adapter<List<PhotosItem>>(type)
        return adapter.fromJson(data)
    }

    @TypeConverter
    @JvmStatic
    fun photosToString(objects: List<PhotosItem>): String {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, PhotosItem::class.java)
        val adapter = moshi.adapter<List<PhotosItem>>(type)
        return adapter.toJson(objects)
    }
}
