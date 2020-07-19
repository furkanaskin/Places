package com.faskn.data.response

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Viewport(
    val southwest: Southwest? = null,
    val northeast: Northeast? = null
) : Parcelable
