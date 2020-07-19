package com.faskn.domain

import com.faskn.core.utils.UseCaseLiveData
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

/**
 * Created by Furkan on 16.07.2020
 */

fun paramToMap(params: UseCaseLiveData.Params): Map<String, String> {
    val moshi = Moshi.Builder().build()
    val adapter = moshi.adapter(params.javaClass)
    val jsonString = adapter.toJson(params)

    val type =
        Types.newParameterizedType(Map::class.java, String::class.java, String::class.java)!!
    val mapAdapter: JsonAdapter<Map<String, String>> = moshi.adapter(type)
    val map = mapAdapter.fromJson(jsonString)

    return map!!
}
