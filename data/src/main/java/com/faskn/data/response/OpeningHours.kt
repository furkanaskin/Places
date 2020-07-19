package com.faskn.data.response

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class OpeningHours(
    val openNow: Boolean? = null
) : Parcelable
